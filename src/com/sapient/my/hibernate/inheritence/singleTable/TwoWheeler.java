package com.sapient.my.hibernate.inheritence.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
public class TwoWheeler extends Vehicle {
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
