//package com.learn.java.sleuth.config;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ReflectionUtils;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders.ResponseBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.Response;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
//
//@Configuration
//@Component
//public class SwaggerConfig {
//
//	@Bean
//	Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).apiInfo(apiInfo())
//				.globalResponses(HttpMethod.GET, list()) // common and apply to all APIs.
//				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
//	}
//
//	private List<Response> list() {
//		List<Response> list = new ArrayList<Response>();
//		list.add(new ResponseBuilder().code("500").description("500 message").build());
//		list.add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
//		return list;
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("Java Learning REST API ")
//				.description("Spring Boot REST API for Swagger Demo Application").version("1.0.0")
//				.termsOfServiceUrl("http://localhost:8080/swagger-ui/index.html")
//				.contact(new Contact("Vitthal Aradwad", "https://www.google.com", "vitthalaradwad@gmail.com"))
//				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//				.build();
//	}
//
////    Exception: Problem
////    Caused by: java.lang.NullPointerException: Cannot invoke "org.springframework.web.servlet.mvc.condition.PatternsRequestCondition.getPatterns()" because "this.condition" is null
////	at springfox.documentation.spring.web.WebMvcPatternsRequestConditionWrapper.getPatterns(WebMvcPatternsRequestConditionWrapper.java:56) ~[springfox-spring-webmvc-3.0.0.jar:3.0.0]
//	// Solution1: @EnableWebMvc
//	// Solution2: below bean
//	@Bean
//	public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
//		return new BeanPostProcessor() {
//
//			@Override
//			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//				if (bean instanceof WebMvcRequestHandlerProvider) {
//					customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
//				}
//				return bean;
//			}
//
//			private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(
//					List<T> mappings) {
//				List<T> copy = mappings.stream().filter(mapping -> mapping.getPatternParser() == null)
//						.collect(Collectors.toList());
//				mappings.clear();
//				mappings.addAll(copy);
//			}
//
//			@SuppressWarnings("unchecked")
//			private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
//				try {
//					Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
//					field.setAccessible(true);
//					return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					throw new IllegalStateException(e);
//				}
//			}
//		};
//	}
//}