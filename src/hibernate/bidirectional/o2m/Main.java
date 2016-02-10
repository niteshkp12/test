package hibernate.bidirectional.o2m;

import hibernate.bidirectional.o2m.DepartmentO2MPojo;
import hibernate.bidirectional.o2m.EmployeeO2MPojo;
import hibernate.util.DatabaseException;
import hibernate.util.PersistenceManager;

import java.util.Map;


/**
 * @type Main
 * @author smahe2
 * @project Hibernate102Assesment
 * @package hibernate.o2m.main
 * @file Main.java
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long id = null;
		try {
			PersistenceManager.beginTransaction();
			
			//create department
			DepartmentO2MPojo department = new DepartmentO2MPojo();
			department.setDeptName("GMI");
			
			//create employee1
			EmployeeO2MPojo employee1 = new EmployeeO2MPojo();
			employee1.setFirstName("Shivam");
			employee1.setLastName("Maheshwari");
			
			//create employee2
			EmployeeO2MPojo employee2 = new EmployeeO2MPojo();
			employee2.setFirstName("Noopur");
			employee2.setLastName("Sinha");
			
			department.addEmployee("emp1", employee1);
			department.addEmployee("emp2", employee2);
			PersistenceManager.persist(department);
			PersistenceManager.commitTransaction();
			id = department.getId();
			System.out.println(id);
		} catch (Exception e) {
			try {
				PersistenceManager.rollbackTransaction();
			} catch (DatabaseException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				PersistenceManager.close();
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}

		try {
			PersistenceManager.beginTransaction();
			DepartmentO2MPojo department = PersistenceManager.find(DepartmentO2MPojo.class, id);
			Map<String, EmployeeO2MPojo> employees = department.getEmployees();
			for(String str : employees.keySet()){
				System.out.println(str);
				System.out.println(employees.get(str).getFirstName() + " " + employees.get(str).getLastName());
			}
			PersistenceManager.commitTransaction();
		} catch (Exception e) {
			try {
				PersistenceManager.rollbackTransaction();
			} catch (DatabaseException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				PersistenceManager.close();
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}
	}
}