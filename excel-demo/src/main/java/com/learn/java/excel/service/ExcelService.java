package com.learn.java.excel.service;

import com.learn.java.excel.model.request.ExcelRequest;

public interface ExcelService {

	public void readOldFile(String file);

	public void readFile(String file);

	public void writeToOldFiles(ExcelRequest excelRequestBody);

}
