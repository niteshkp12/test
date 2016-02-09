package com.sapient.my.hibernate.address;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails_HTO11_ConfiguringCollectionsandAddingKeys where userId=?")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from USER_DETAILS where USER_NAME=?", resultClass = UserDetails_HTO11_ConfiguringCollectionsandAddingKeys.class)
@Table(name = "USER_DETAILS")
public class UserDetails_HTO11_ConfiguringCollectionsandAddingKeys {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String name;

	@ElementCollection
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> addresses = new ArrayList<Address>();

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
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

	@Override
	public String toString() {
		return "UserDetails_HTO11_ConfiguringCollectionsandAddingKeys [userId="
				+ userId + ", name=" + name + ", addresses="
				+ addresses.toString() + "]";
	}

}
