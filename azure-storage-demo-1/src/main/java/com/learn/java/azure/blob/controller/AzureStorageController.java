package com.learn.java.azure.blob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.azure.blob.service.AzureStorageService;

@RestController
@RequestMapping("/azure/storage/demo")
public class AzureStorageController {

	@Autowired 
	private AzureStorageService azureStorageService;
	
	@GetMapping("/blob")
	String getBlob() {
		azureStorageService.getBlob("fileName");
		return "fetched blob file.";
	}

	@PostMapping("/blob")
	String addBlob() {
		azureStorageService.addBlob("fileName");
		return "added blob file.";
	}

	
	@PutMapping("/blob")
	String updateBlob() {
		azureStorageService.updateBlob("fileName");
		return "updated blob file.";
	}

	
	@DeleteMapping("/blob")
	String deleteBlob() {
		azureStorageService.deleteBlob("fileName");
		return "deleted blob file.";
	}

	
}
