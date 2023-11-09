package com.learn.java.swagger.model;

public class Item2 {

	String item;

	public Item2() {
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
