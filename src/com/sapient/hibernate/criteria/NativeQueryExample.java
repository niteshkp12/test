package com.sapient.hibernate.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @author Deepak Kumar
 * 
 * http://www.roseindia.net Hibernate Native Query Example
 *  
 */
public class NativeQueryExample {
	public static void main(String[] args) {
		Session session = null;

		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session =sessionFactory.openSession();
			/* Hibernate Native Query Average Examle*/
		 	String sql ="select stddev(ins.investementAmount) as stdErr, "+
		 		" avg(ins.investementAmount) as mean "+
		 		" from INSURANCE ins";
		 	Query query = session.createSQLQuery(sql).addScalar("stdErr");
//		 	Query query = session.createSQLQuery(sql).addScalar("stdErr",Hibernate.DOUBLE).
//			 		addScalar("mean",Hibernate.DOUBLE);
	 		//Double [] amount = (Double []) query.uniqueResult(); 
		 	Object [] amount = (Object []) query.uniqueResult(); 
 			System.err.println("mean amount: " + amount[0]);
 			System.err.println("stdErr amount: " + amount[1]);

 			/* Example to show Native query to select all the objects from database */
 			/* Selecting all the objects from insurance table */
 			List<?> insurance = session.createSQLQuery("select  {ins.*}  from INSURANCE ins")
			.addEntity("ins", Insurance.class)
		    .list();
			for (Iterator<?> it = insurance.iterator(); it.hasNext();) {
				Insurance insuranceObject = (Insurance) it.next();
				System.err.println("ID: " + insuranceObject.getLngInsuranceId());
				System.err.println("Name: " + insuranceObject.getInsuranceName());
			}
			
	        session.close();
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
