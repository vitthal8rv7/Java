package com.learn.java.graphql.model;

import java.io.Serializable;

public class Address implements Serializable {

		private static final long serialVersionUID = 8776473532712411206L;

		private String house;
		
		private String line;
		
		private String city;
		
		private Integer pincode;
		
		private String country;

		public String getHouse() {
			return house;
		}

		public void setHouse(String house) {
			this.house = house;
		}

		public String getLine() {
			return line;
		}

		public void setLine(String line) {
			this.line = line;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Integer getPincode() {
			return pincode;
		}

		public void setPincode(Integer pincode) {
			this.pincode = pincode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		@Override
		public String toString() {
			return "Address [house=" + house + ", line=" + line + ", city=" + city + ", pincode=" + pincode
					+ ", country=" + country + "]";
		}
}
