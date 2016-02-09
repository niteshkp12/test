package com.sapient.hibernate.criteria;

import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

/**
 * @author Deepak Kumar
 * 
 *         http://www.roseindia.net HQL Select Clause Example
 */
public class HibernateProjection {
	public static void main(String[] args) {
		Session session = null;

		try {
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from Insurance");
			Criteria criteria = session.createCriteria(Insurance.class);
			
//			criteria.setProjection(Projections.property("insuranceName"));
//			criteria.setProjection(Projections.property("lngInsuranceId"));
			
			ProjectionList projectionList = Projections.projectionList();
//			projectionList.add(Projections.property("lngInsuranceId"));
			projectionList.add(Projections.max("lngInsuranceId"));
			criteria.setProjection(projectionList);
			
			List list = criteria.list();
			for (Object s :list) { 
					System.err.println( s);
			}
			
			/*List<Insurance> list = criteria.list();
			for (Insurance insurance : list) {
				System.err.println("ID: " + insurance.getLngInsuranceId()
						+ " Name: " + insurance.getInsuranceName()
						+ " Amount: " + insurance.getInvestementAmount());
			}*/
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}
}
