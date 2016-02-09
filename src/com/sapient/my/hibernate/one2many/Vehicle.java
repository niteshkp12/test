package com.sapient.my.hibernate.one2many;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_ONE_2_MANY")
// @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(
// name="VEHICLE_TYPE",
// discriminatorType=DiscriminatorType.STRING
// )
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;

	@ManyToOne
	@JoinTable(name = "USER_VEHICLE", joinColumns=@JoinColumn(name="VEHICLE_USER"))
	private UserDetails details;

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
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
