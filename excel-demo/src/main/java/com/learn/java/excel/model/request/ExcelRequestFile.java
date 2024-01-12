package com.learn.java.excel.model.request;

import java.io.Serializable;

public class ExcelRequestFile implements Serializable {

	private static final long serialVersionUID = 2574981969595913797L;

	private String fileName;
	
	private WorkbookRequest workbook;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public WorkbookRequest getWorkbook() {
		return workbook;
	}

	public void setWorkbook(WorkbookRequest workbook) {
		this.workbook = workbook;
	}

	@Override
	public String toString() {
		return "ExcelRequestFile [fileName=" + fileName + ", workbook=" + workbook + "]";
	}
}
