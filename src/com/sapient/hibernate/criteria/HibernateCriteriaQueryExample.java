package com.sapient.hibernate.criteria;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * @author Deepak Kumar
 * 
 *         http://www.roseindia.net Hibernate Criteria Query Example
 * 
 */
public class HibernateCriteriaQueryExample {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			/* Inserting the elements in the Insurance table
			 * for (int i = 0; i < 10; i++) { Insurance insurance = new
			 * Insurance("Insurance_" + i, i * 100, new Date());
			 * session.save(insurance); }
			 */

			// Criteria Query Example
			Criteria criteria = session.createCriteria(Insurance.class);
			criteria.add(Restrictions.eq("lngInsuranceId", 8l));
			
			List<?> insurances = criteria.list();
			for (Iterator<?> it = insurances.iterator(); it.hasNext();) {
				Insurance insurance = (Insurance) it.next();
				System.err.println("ID: " + insurance.getLngInsuranceId()
						+ " || Name: " + insurance.getInsuranceName());

			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}
}
