package com.learn.java.azure.blob.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;
import com.learn.java.azure.blob.model.Storage;
import com.nimbusds.oauth2.sdk.util.StringUtils;

@Service
public class AzureStorageServiceImpl implements AzureStorageService {

	@Value("${azure.storage.container.name}")
	private String containerName; // fetch it from properties file.

	@Autowired
	private BlobServiceClient blobServiceClient;

	@Autowired
	private BlobContainerClient blobContainerClient;

	@Override
	public void createContainer() {
		blobServiceClient.createBlobContainer(containerName);
	}

	@Override
	public void deleteContainer() {
		blobServiceClient.deleteBlobContainer(containerName);
	}

	@Override
	public byte[] readBlob(Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listBlob(Storage storage) {
//		PagedIterable<BlobItem> blobItems = blobContainerClient.listBlobs();
		PagedIterable<BlobItem> blobItems = blobContainerClient.listBlobsByHierarchy(storage.getPath() + "/");
		return blobItems.stream().map(BlobItem::getName).collect(Collectors.toList());
	}

	@Override
	public String writeBlob(Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateBlob(Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBlob(Storage storage) {
		String blobPath = getBlobPath(storage);
		BlobClient blobClient = blobContainerClient.getBlobClient(blobPath);
		blobClient.delete();
	}

	private String getBlobPath(Storage storage) {
		if (StringUtils.isNotBlank(storage.getPath() + storage.getFileName())) {
			return storage.getPath() + "/" + storage.getFileName();
		} else {
			return "";
		}
	}

}
