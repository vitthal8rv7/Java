package com.learn.java.azure.blob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.azure.blob.model.Storage;
import com.learn.java.azure.blob.service.AzureStorageService;

@RestController
@RequestMapping("/azure/storage/demo")
public class AzureStorageController {

	@Autowired 
	private AzureStorageService azureStorageService;
	
	@PostMapping("/create/container")
	String createContainer() {
		azureStorageService.createContainer();
		return "created container.";
	}

	@DeleteMapping("/delete/container")
	String deleteContainer() {
		azureStorageService.deleteContainer();
		return "delete container.";
	}

	@GetMapping("/blob/list")
	String listBlob() {
		azureStorageService.listBlob(new Storage());
		return "fetched blob file.";
	}

	@GetMapping("/read/blob")
	String readBlob() {
		azureStorageService.readBlob(new Storage());
		return "fetched blob file.";
	}

	@PostMapping("/blob")
	String addBlob() {
		azureStorageService.writeBlob(new Storage());
		return "added blob file.";
	}

	
	@PutMapping("/blob")
	String updateBlob() {
		azureStorageService.updateBlob(new Storage());
		return "updated blob file.";
	}

	
	@DeleteMapping("/blob")
	String deleteBlob() {
		azureStorageService.deleteBlob(new Storage());
		return "deleted blob file.";
	}

	
}
