package com.learn.java.azure.blob;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

@Configuration
public class AzureStorageConfiguration {

	@Value("${azure.storage.container.name}")
	private String containerName; // fetch it from properties file.

	@Value("${azure.storage.connection.string}")
	private String connectStr; // fetch it from properties file.

	@Bean
	BlobServiceClient getBlobServiceClient() {
		return new BlobServiceClientBuilder().connectionString(connectStr).buildClient();
	}

	@Bean
	BlobContainerClient getBlobContainerClient() {
		return getBlobServiceClient().getBlobContainerClient(containerName);
	}

}
