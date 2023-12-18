package com.learn.java.excel.model.request;

import java.io.Serializable;
import java.util.List;

public class RowRequest implements Serializable {

	private static final long serialVersionUID = -7460080152427061871L;
	
	private List<CellRequest> cellRequest;

	public List<CellRequest> getCellRequest() {
		return cellRequest;
	}

	public void setCellRequest(List<CellRequest> cellRequest) {
		this.cellRequest = cellRequest;
	}

	@Override
	public String toString() {
		return "RowRequest [cellRequest=" + cellRequest + "]";
	}
}
