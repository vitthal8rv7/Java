/*
 * Copyright 2013-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package integration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import brave.Span;
import brave.Tracer;
import brave.handler.MutableSpan;
import brave.handler.SpanHandler;
import brave.sampler.Sampler;
import integration.MessagingApplicationTests.IntegrationSpanCollectorConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sample.SampleMessagingApplication;
import tools.AbstractIntegrationTest;
import tools.SpanUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(classes = { IntegrationSpanCollectorConfig.class, SampleMessagingApplication.class },
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = { "sample.zipkin.enabled=true" })
@DirtiesContext
public class MessagingApplicationTests extends AbstractIntegrationTest {

	private static int port = 3381;

	private static String sampleAppUrl = "http://localhost:" + port;

	@Autowired
	IntegrationTestZipkinSpanHandler testSpanHandler;

	@Autowired
	Tracer tracer;

	@AfterEach
	public void cleanup() {
		this.testSpanHandler.spans.clear();
	}

	@Test
	public void should_have_passed_trace_id_when_message_is_about_to_be_sent() {
		Span span = tracer.nextSpan().start();
		long traceId = span.context().traceId();

		await().atMost(3, SECONDS).untilAsserted(
				() -> httpMessageWithTraceIdInHeadersIsSuccessfullySent(sampleAppUrl + "/", traceId).run());

		span.finish();
		await().atMost(3, SECONDS).untilAsserted(() -> thenAllSpansHaveTraceIdEqualTo(traceId));
	}

	@Test
	public void should_have_passed_trace_id_and_generate_new_span_id_when_message_is_about_to_be_sent() {
		Span span = tracer.nextSpan().start();
		long traceId = span.context().traceId();
		long spanId = span.context().spanId();

		await().atMost(3, SECONDS).untilAsserted(
				() -> httpMessageWithTraceIdInHeadersIsSuccessfullySent(sampleAppUrl + "/", traceId, spanId).run());

		span.finish();
		await().atMost(3, SECONDS).untilAsserted(() -> {
			thenAllSpansHaveTraceIdEqualTo(traceId);
			thenTheSpansHaveProperParentStructure();
		});
	}

	@Test
	public void should_have_passed_trace_id_with_annotations_in_async_thread_when_message_is_about_to_be_sent() {
		Span span = tracer.nextSpan().start();
		long traceId = span.context().traceId();

		await().atMost(3, SECONDS).untilAsserted(
				() -> httpMessageWithTraceIdInHeadersIsSuccessfullySent(sampleAppUrl + "/xform", traceId).run());

		span.finish();
		await().atMost(3, SECONDS).untilAsserted(() -> {
			thenAllSpansHaveTraceIdEqualTo(traceId);
			thenThereIsAtLeastOneTagWithKey("background-sleep-millis");
		});
	}

	private void thenThereIsAtLeastOneTagWithKey(String key) {
		then(spans().stream().map(MutableSpan::tags).flatMap(m -> m.keySet().stream()).anyMatch(b -> b.equals(key)))
				.isTrue();
	}

	private List<MutableSpan> spans() {
		return new ArrayList<>(this.testSpanHandler.spans);
	}

	private void thenAllSpansHaveTraceIdEqualTo(long traceId) {
		String traceIdHex = Long.toHexString(traceId);
		log.info("Stored spans: [\n" + spans().stream().map(MutableSpan::toString).collect(Collectors.joining("\n"))
				+ "\n]");
		then(spans().stream().filter(span -> !span.traceId().equals(SpanUtil.idToHex(traceId)))
				.collect(Collectors.toList())).describedAs("All spans have same trace id [" + traceIdHex + "]")
						.isEmpty();
	}

	private void thenTheSpansHaveProperParentStructure() {
		Optional<MutableSpan> firstHttpSpan = findFirstHttpRequestSpan();
		List<MutableSpan> eventSpans = findAllEventRelatedSpans();
		Optional<MutableSpan> eventSentSpan = findSpanWithKind(Span.Kind.SERVER);
		Optional<MutableSpan> producerSpan = findSpanWithKind(Span.Kind.PRODUCER);
		Optional<MutableSpan> lastHttpSpansParent = findLastHttpSpansParent();
		// "http:/parent/" -> "message:messages" -> "http:/foo" (CS + CR) -> "http:/foo"
		// (SS)
		thenAllSpansArePresent(firstHttpSpan, eventSpans, lastHttpSpansParent, eventSentSpan, producerSpan);
		List<MutableSpan> spans = spans();
		then(spans).as("There were 6 spans").hasSize(6);
		log.info("Checking the parent child structure");
		List<Optional<MutableSpan>> parentChild = spans.stream().filter(span -> span.parentId() != null).map(span -> {
			Optional<MutableSpan> any = spans.stream().filter(span1 -> span1.id().equals(span.parentId())).findAny();
			if (!any.isPresent()) {
				log.warn("Span with id [" + span.id() + "] and parent span id [" + span.parentId()
						+ "] doesn't have a corresponding span with id equal to parent id");
			}
			return any;
		}).collect(Collectors.toList());
		log.info("List of parents and children " + parentChild);
		then(parentChild.stream().allMatch(Optional::isPresent)).isTrue();
	}

	private Optional<MutableSpan> findLastHttpSpansParent() {
		return spans().stream().filter(span -> "GET /".equals(span.name()) && span.kind() != null).findFirst();
	}

	private Optional<MutableSpan> findSpanWithKind(Span.Kind kind) {
		return spans().stream().filter(span -> kind.equals(span.kind())).findFirst();
	}

	private List<MutableSpan> findAllEventRelatedSpans() {
		return spans().stream().filter(span -> "send".equals(span.name()) && span.parentId() != null)
				.collect(Collectors.toList());
	}

	private Optional<MutableSpan> findFirstHttpRequestSpan() {
		return spans().stream()
				// home is the name of the method
				.filter(span -> span.tags().values().stream().anyMatch("home"::equals)).findFirst();
	}

	private void thenAllSpansArePresent(Optional<MutableSpan> firstHttpSpan, List<MutableSpan> eventSpans,
			Optional<MutableSpan> lastHttpSpan, Optional<MutableSpan> eventSentSpan,
			Optional<MutableSpan> eventReceivedSpan) {
		log.info("Found following spans");
		log.info("First http span " + firstHttpSpan);
		log.info("Event spans " + eventSpans);
		log.info("Event sent span " + eventSentSpan);
		log.info("Event received span " + eventReceivedSpan);
		log.info("Last http span " + lastHttpSpan);
		log.info("All found spans \n" + spans().stream().map(MutableSpan::toString).collect(Collectors.joining("\n")));
		then(firstHttpSpan.isPresent()).isTrue();
		then(eventSpans).isNotEmpty();
		then(eventSentSpan.isPresent()).isTrue();
		then(eventReceivedSpan.isPresent()).isTrue();
		then(lastHttpSpan.isPresent()).isTrue();
	}

	@Configuration(proxyBeanMethods = false)
	public static class IntegrationSpanCollectorConfig {

		@Bean
		SpanHandler testSpanHandler() {
			return new IntegrationTestZipkinSpanHandler();
		}

		@Bean
		Sampler sampler() {
			return Sampler.ALWAYS_SAMPLE;
		}

	}

}
