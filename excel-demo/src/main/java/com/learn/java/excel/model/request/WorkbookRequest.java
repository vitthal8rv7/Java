package com.learn.java.excel.model.request;

import java.io.Serializable;
import java.util.List;

public class WorkbookRequest implements Serializable {
	
	private static final long serialVersionUID = 5017598844685711009L;
	
	private String sheetName;
	
	private List<RowRequest> rowRequest;

	public List<RowRequest> getRowRequest() {
		return rowRequest;
	}

	public void setRowRequest(List<RowRequest> rowRequest) {
		this.rowRequest = rowRequest;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	@Override
	public String toString() {
		return "WorkbookRequest [sheetName=" + sheetName + ", rowRequest=" + rowRequest + "]";
	}	
}
