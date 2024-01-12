package com.learn.java.excel.model.request;

import java.io.Serializable;
import java.util.ArrayList;

public class ExcelRequest implements Serializable {

	private static final long serialVersionUID = -5167218374725954539L;
	
	private ArrayList<ExcelRequestFile> excelRequestFiles;

	public ArrayList<ExcelRequestFile> getExcelRequestFiles() {
		return excelRequestFiles;
	}

	public void setExcelRequestFiles(ArrayList<ExcelRequestFile> excelRequestFiles) {
		this.excelRequestFiles = excelRequestFiles;
	}

	@Override
	public String toString() {
		return "ExcelRequest [excelRequestFiles=" + excelRequestFiles + "]";
	}
}
