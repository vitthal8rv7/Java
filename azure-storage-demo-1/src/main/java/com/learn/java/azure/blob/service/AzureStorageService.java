package com.learn.java.azure.blob.service;

import java.util.List;

import com.learn.java.azure.blob.model.Storage;

public interface AzureStorageService {

	public byte[] readBlob(Storage storage);
	
	public List<String> listBlob(Storage storage);

	public String writeBlob(Storage storage);

	public String updateBlob(Storage storage);

	public void deleteBlob(Storage storage);

	public void createContainer();

	public void deleteContainer();

}
