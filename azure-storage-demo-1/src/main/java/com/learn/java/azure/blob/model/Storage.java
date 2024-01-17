package com.learn.java.azure.blob.model;

import java.io.InputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Storage implements Serializable {
	
	private static final long serialVersionUID = -4730457468960033240L;
	private String path;
	private String fileName;
	private InputStream inputStream;
}
