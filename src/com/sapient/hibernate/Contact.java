package com.sapient.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Deepak Kumar
 *
 * http://www.roseindia.net
 * Java Class to map to the datbase Contact Table
 */
@Entity(name="CONTACT")
@Table(name="CONTACT_DETAIL")
public class Contact {
	
	@Column(name="First_Name")
	private String firstName;
	private String lastName;
	private String email;
	@Id
	@SequenceGenerator(sequenceName="seq", allocationSize=1, name = "seq")
	@GeneratedValue(generator="seq", strategy=GenerationType.SEQUENCE)
	private int id;

	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/** 
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", id=" + id + "]";
	}

	/**
	 * @param string Sets the Email
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string Sets the First Name
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string sets the Last Name
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param l Sets the ID
	 */
	public void setId(int l) {
		id = l;
	}

}
