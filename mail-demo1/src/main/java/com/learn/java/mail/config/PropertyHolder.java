/**
 * Copyright (c) 2018 ELC Inc. All rights reserved.
 */
package com.learn.java.mail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Property Holder consisting externalised properties
 * 
 * @author Mindstix
 */

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class PropertyHolder {

	@Value("${mail.smtp.host}")
	String host;

	@Value("${mail.smtp.port}")
	String port;

	@Value("${mail.smtp.auth}")
	String auth;

	@Value("${mail.smtp.starttls.enable}")
	String startTls;

	@Value("${mail.from}")
	String mailFrom;

	@Value("${mail.pwd}")
	String mailPwd;

	@Value("${mail.to}")
	String mailTo;

	@Value("${mail.imap.host}")
	String imapHost;

	@Value("${mail.imap.port}")
	String imapPort;

	@Value("${mail.imap.ssl.enable}")
	String imapSslEnable;

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getAuth() {
		return auth;
	}

	public String getStartTls() {
		return startTls;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public String getMailPwd() {
		return mailPwd;
	}

	public String getMailTo() {
		return mailTo;
	}

	public String getImapHost() {
		return imapHost;
	}

	public String getImapPort() {
		return imapPort;
	}

	public String getImapSslEnable() {
		return imapSslEnable;
	}
}