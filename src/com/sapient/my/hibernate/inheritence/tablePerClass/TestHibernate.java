package com.sapient.my.hibernate.inheritence.tablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setSteeringHandle("Handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setSteeringWheel("Steering");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.getTransaction().commit();
		session.close();
	}
}
