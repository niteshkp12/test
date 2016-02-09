package com.sapient.my.hibernate.one2many;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setName("nitesh");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicle);
		vehicle.setDetails(user);
		user.setVehicleList(vehicles);
		
/*		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("bike");
		twoWheeler.setSteeringWheel("Bike Handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("jeep");
		fourWheeler.setSteeringWheel("Maruti Steering");
*/		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
//		session.save(vehicle);
/*		session.save(twoWheeler);
		session.save(fourWheeler);
*/		
		session.getTransaction().commit();
		session.close();
	}
}
