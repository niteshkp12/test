package com.sapient.my.hibernate.address;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernateHT011 {

	public static void main(String[] args) {
		// Inserting Records
		/*
		 * UserDetails_HTO11_ConfiguringCollectionsandAddingKeys user = new
		 * UserDetails_HTO11_ConfiguringCollectionsandAddingKeys();
		 * user.setName("nitesh");
		 * 
		 * Address address = new Address(); address.setCity("Delhi");
		 * address.setStreet("old delhi"); address.setPinCode(123456);
		 * 
		 * Address address2 = new Address(); address2.setCity("Gurgaon");
		 * address2.setStreet("old Gurgaon"); address2.setPinCode(1234);
		 * 
		 * user.getAddresses().add(address); user.getAddresses().add(address2);
		 */
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// session.save(user);

		String userId = "1";
		String userName = "nitesh";
		//Parameter Binding
		/*Query query = session
				.createQuery("from UserDetails_HTO11_ConfiguringCollectionsandAddingKeys where userId = ? and name = ?");
		query.setInteger(0, Integer.parseInt(userId));
		query.setString(1, userName);*/

		//Named Parameter Binding
		/*Query query = session
				.createQuery("from UserDetails_HTO11_ConfiguringCollectionsandAddingKeys where userId = :userId and name = :name");
		query.setInteger("userId", Integer.parseInt(userId));
		query.setString("name", userName);*/
		
		//Named Query
		/*Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, 1);*/
		
		//Named Native Query
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "nitesh");
		
		List<UserDetails_HTO11_ConfiguringCollectionsandAddingKeys> users = query
				.list();
		users = query.list();
		for (UserDetails_HTO11_ConfiguringCollectionsandAddingKeys u : users) {
			System.err.println("UserId: " + u.getUserId());
			System.err.println("UserName: " + u.getName());
		}
		session.getTransaction().commit();
		session.close();
	}
}
