package com.sapient.my.hibernate.address;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails_HT09_AttributeOverrides {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true)
	private int userId;

	@Column(name = "USER_NAME", unique = true)
	private String name;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column = @Column(name="HOME_STREET")),
		@AttributeOverride(name="city", column = @Column(name="HOME_CITY")),
		@AttributeOverride(name="pinCode", column = @Column(name="HOME_PINCODE"))
	})
	private Address homeAddress;

	@Embedded
	private Address officeAddress;

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
