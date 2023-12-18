package com.learn.java.excel.model.request;

import java.io.Serializable;

/*
 * Need to wrok very deeply, use Best of Generics and Types and Inheritance and Reflection APis and so on...
 * .... make it auto-fill Excel file.
 * ------ JSON to Excel Convertor, XML to Excel convertor...and so on... 
 * 
 * */
public class CellRequest implements Serializable {
	
	private static final long serialVersionUID = 6290174691750178411L;

	private Integer cellIndex;

	private String valueType;

	private String value;

	public Integer getCellIndex() {
		return cellIndex;
	}

	public void setCellIndex(Integer cellIndex) {
		this.cellIndex = cellIndex;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	@Override
	public String toString() {
		return "CellRequest [cellIndex=" + cellIndex + ", valueType=" + valueType + ", value=" + value + "]";
	}

}
