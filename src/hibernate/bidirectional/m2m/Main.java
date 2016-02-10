package hibernate.bidirectional.m2m;

import hibernate.bidirectional.m2m.DepartmentM2MPojo;
import hibernate.bidirectional.m2m.EmployeeM2MPojo;
import hibernate.util.DatabaseException;
import hibernate.util.PersistenceManager;

public class Main {
	public static void main(String[] args) {
		try {
			PersistenceManager.beginTransaction();
			
			DepartmentM2MPojo dept1 = new DepartmentM2MPojo("GMI");
			DepartmentM2MPojo dept2 = new DepartmentM2MPojo("Finance");
			
			
			EmployeeM2MPojo emp1 = new EmployeeM2MPojo();
			emp1.setName("Shivam");
			
			EmployeeM2MPojo emp2 = new EmployeeM2MPojo();
			emp2.setName("Noopur");
			
			EmployeeM2MPojo emp3 = new EmployeeM2MPojo();
			emp3.setName("Mamta");
			
			EmployeeM2MPojo emp4 = new EmployeeM2MPojo();
			emp4.setName("Rakesh");
			
			EmployeeM2MPojo emp5 = new EmployeeM2MPojo();
			emp5.setName("Amlesh");
			
			dept1.addEmployee(emp1);
			dept1.addEmployee(emp2);
			dept1.addEmployee(emp3);
			dept2.addEmployee(emp5);
			
			dept2.addEmployee(emp2);
			dept2.addEmployee(emp3);
			dept2.addEmployee(emp4);
			
			PersistenceManager.getEntityManager().persist(dept1);
			PersistenceManager.getEntityManager().persist(dept2);
			PersistenceManager.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				PersistenceManager.rollbackTransaction();
			} catch (DatabaseException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				PersistenceManager.close();
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}
	}
}
