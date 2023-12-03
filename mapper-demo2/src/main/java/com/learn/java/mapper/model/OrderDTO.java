package com.learn.java.mapper.model;

import java.io.Serializable;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 7168612153056461303L;

	String customerFirstName;

	String customerLastName;

	String billingStreet;

	String billingCity;

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	@Override
	public String toString() {
		return "OrderDTO [customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", billingStreet=" + billingStreet + ", billingCity=" + billingCity + "]";
	}
}
