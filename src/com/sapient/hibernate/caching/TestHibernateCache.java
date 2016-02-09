package com.sapient.hibernate.caching;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class TestHibernateCache {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// Student student = new Student();
		// student.setName("Kumar");
		// session.save(student);

		// Student student= (Student) session.get(Student.class, 1);

		Query query = session.createQuery("from Student");
		//Below line enables to cache the query result 
		query.setCacheable(true);
		List<Student> student = query.list();
		session.close();

		session = sessionFactory.openSession();
		query = session.createQuery("from Student");
		//Below line here enables to look in cache for the results
		query.setCacheable(true);
		student = query.list();
		session.close();

	}
}
