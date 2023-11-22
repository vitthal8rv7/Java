/**
 * Copyright (c) 2018 ELC Inc. All rights reserved.
 */
package com.learn.java.notification.config;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * Property Holder consisting externalised properties
 * 
 * @author Mindstix
 */
@Data
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class PropertyHolder {

//	@Value("${OAUTH_CLIENT_ID}")
//	private String clientId;
//
//	@Value("${OAUTH_CLIENT_SECRET}")
//	private String clientSecret;
//
//	@Value("${PROJECT_NAMESPACE:TROTM_}")
//	private String projectNamespace;
//
//	@Value("${PROJECT_NAMESPACE_TRLX:TRLX_}")
//	private String projectNamespaceForTRLX;
//
//	@Value("${FAIL_ON_UNKNOWN_PROPERTY:false}")
//	private String failOnUnknownProperty;
//
//	@Value("${azure.storage.container-name:trotm}")
//	private String containerName;
//
//	@Value("${app.service.hostname}")
//	private String appServiceHostName;
//
//	@Value("${app.service.host}")
//	private String appServiceHost;
//
//	@Value("${app.service.subscription}")
//	private String appServiceSubscriptionKey;
//
//	@Value("${app.cmsservice.host}")
//	private String cmsServiceHost;
//
//	@Value("${app.cmsservice.subscription}")
//	private String cmsServiceSubscriptionKey;
//
//	@Value("${repair.request.mail.from}")
//	private String repairRequestMailFrom;
//
//	@Value("${repair.request.notify.vendor.mail.subject}")
//	private String repairRequestNotifyVendorMailSubject;
//
//	@Value("${repair.request.submission.mail.subject}")
//	private String repairRequestSubmissionMailSubject;
//
//	@Value("${repair.request.submission.company.mail.subject}")
//	private String repairRequestSubmissionCompanyMailSubject;
//
//	@Value("${storevisit.mail.from}")
//	private String storeVisitMailFrom;
//
//	@Value("${storevisit.submission.mail.subject}")
//	private String storeVisitSubmissionMailSubject;
//
//	@Value("${repair.request.status.change.mail.subject}")
//	private String repairStatusChangeRequestMailSubject;
//
//	@Value("${repair.request.sdvm.team.mail.subject}")
//	private String repairRequestSDVMTeamMailSubject;
//
//	@Value("${repair.request.submitter.not.responded.mail.subject}")
//	private String repairRequestSubmitterNotRespondedMailSubject;
//
//	@Value("${store.comment.tag.mail.subject}")
//	private String storeCommentTagMailSubject;
//
//	@Value("${store.visit.tag.mail.subject}")
//	private String storeVisitTagMailSubject;

	@Value("${fcm.server.key}")
	private String firebaseServerKey;

//	@Value("${repair.request.frontend.domain.name}")
//	private String repairRequestFrontendDomainName;
//
//	@Value("${CMS_HOSTNAME}")
//	private String cmsHostName;
//
//	@Value("${spring.redis.host}")
//	private String redisHostName;
//
//	@Value("${spring.redis.password}")
//	private String redisPassword;
//
//	@Value("#{'${otm.email.cc.list}'.split(',')}")
//	private List<String> otmEmailCCList;
//
//	@Value("#{'${repair.request.vm.supported.regions}'.split(',')}")
//	private List<String> vmRepairSupportedRegions;
//
//	@Value("${otm.authorization.token}")
//	private String otmAuthorizationToken;
//
//	@Value("${repair.request.comment.mail.subject}")
//	private String repairRequestCommentMailSubject;

	@Value("${fcm.notification.send.endpoint}")
	private String fcmEndpoint;

	@Value("${time.unit}")
	private String timeUnit;

//	@Value("#{'${master.data.audit.trail.email.to.list}'.split(',')}")
//	private List<String> masterDataAuditTrailToList;
//
//	@Value("${authenticationkey}")
//	private String authenticationKey;

	
	
	@Value("${spring.application.name}")
	private String springApplicationName;

	public String getFirebaseServerKey() {
		return firebaseServerKey;
	}

	public String getFcmEndpoint() {
		return fcmEndpoint;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public String getSpringApplicationName() {
		return springApplicationName;
	}

	public Long getTimeStamp(Long offset) {
		try {
			return Instant.now().toEpochMilli() - TimeUnit.valueOf(timeUnit).toMillis(offset);
		} catch (IllegalArgumentException e) {
			return Instant.now().toEpochMilli() - TimeUnit.DAYS.toMillis(offset);
		}
	}

	public Long getCurrentTimeStamp() {
		return Instant.now().toEpochMilli();
	}
}