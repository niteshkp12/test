package com.sapient.my.hibernate.address;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Address {
	
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="PIN_CODE")
	private int pinCode;

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", pinCode="
				+ pinCode + "]";
	}
}
