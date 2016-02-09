package com.sapient.my.hibernate.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setName("nitesh");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		user.setVehicle(vehicle);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
		}
		session.close();
	}

}
