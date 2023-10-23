package com.learn.java.rest.model;

public class Item {

	String item;

	public Item() {
		this.item = this.getClass().getName();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Item [item=" + item + "]";
	}
}
