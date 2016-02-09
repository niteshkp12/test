package com.sapient.my.hibernate.one2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_ONE_2_MANY")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String name;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="vehicleId")
//	@JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
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
