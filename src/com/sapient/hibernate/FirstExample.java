package com.sapient.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class FirstExample {
	public static void main(String[] args) {
		Session session = null;

		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new AnnotationConfiguration()
					.configure().buildSessionFactory();
			session = sessionFactory.openSession();
			// Create new instance of Contact and set values in it by reading
			// them from form object

			Transaction tx = (Transaction) session.beginTransaction();
			System.out.println("Inserting Record");
			Contact contact = new Contact();
			contact.setId(6);
			contact.setFirstName("Nitesh");
			contact.setLastName("Kumar");
			contact.setEmail("nitesh@gmail.com");
			session.save(contact);
			
			 session.load(Contact.class, 1);
			System.err.println("nitesh: " + contact);
			
			// System.err.println(session.save(contact));
			tx.commit();
			session.flush();
			session.close();

			/*
			 * contact = null; session = sessionFactory.openSession();
			 * session.beginTransaction(); contact = (Contact)
			 * session.load(Contact.class, 1); System.err.println("Contact " +
			 * contact); //session.save(contact);
			 * session.getTransaction().commit(); session.close();
			 */
			// session.get(Contact.class, 1L);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			// Actual contact insertion will happen at this step
			// session.flush();
			// session.close();

		}

	}
}
