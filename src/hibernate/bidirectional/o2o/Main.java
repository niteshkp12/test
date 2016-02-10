package hibernate.bidirectional.o2o;

import hibernate.util.DatabaseException;
import hibernate.util.PersistenceManager;

public class Main {
	public static void main(String[] args) {
		try {
			PersistenceManager.beginTransaction();
			//create employee
			EmployeeO2OPojo employee = new EmployeeO2OPojo();
			employee.setFirstName("Nitesh");
			employee.setLastName("Prajapati");

			//create Department
			DepartmentO2OPojo department = new DepartmentO2OPojo();
			department.setDeptName("Finance");
			
			//set employee.department = department
			employee.setDepartment(department);
			
			//persist
			PersistenceManager.getEntityManager().persist(employee);
			
			//commit
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
				//close
				PersistenceManager.close();
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}
	}
}