package com.sapient.my.hibernate.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setName("nitesh");

		UserDetails user2 = new UserDetails();
		user2.setName("Kumar");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("jeep");

		vehicle.getUserList().add(user);
		vehicle.getUserList().add(user2);

		vehicle2.getUserList().add(user);

		user.getVehicleList().add(vehicle);
		user2.getVehicleList().add(vehicle);
		user.getVehicleList().add(vehicle2);

		SessionFactory sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(vehicle2);
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
	}
}
