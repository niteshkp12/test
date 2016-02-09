package com.sapient.my.hibernate.many2many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_MANY_2_MANY")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;

	@ManyToMany(mappedBy="vehicleList")
	private List<UserDetails> userList = new ArrayList<UserDetails>();

	public List<UserDetails> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDetails> userList) {
		this.userList = userList;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
