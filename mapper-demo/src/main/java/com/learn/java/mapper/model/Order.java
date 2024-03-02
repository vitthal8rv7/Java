package com.learn.java.mapper.model;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 5096376090670256140L;

	private Customer customer;

	private Address4 billingAddress;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address4 getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address4 billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", billingAddress=" + billingAddress + "]";
	}
}
