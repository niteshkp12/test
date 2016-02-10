/**
 * @file: DepartmentO2MPojo.java
 * @project: Hibernate102Assesment
 * @package: hibernate.o2o.main
 * @author: smahe2
 * @created: Sep 26, 2011 7:06:54 PM
 */
package hibernate.bidirectional.o2m;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @type DepartmentO2MPojo
 * @author smahe2
 * @project Hibernate102Assesment
 * @package hibernate.o2o.main
 * @file DepartmentO2MPojo.java
 */
@Entity
@Table(name="o2m_department")
public class DepartmentO2MPojo {
	/**
	 *@field id
	 *@type Long 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 *@field deptName
	 *@type String 
	 */
	@Column(name="dept_name")
	private String deptName;

	/**
	 *@field employees
	 *@type Map<String,EmployeeO2MPojo> 
	 */
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@MapKey(name = "type")
	private Map<String, EmployeeO2MPojo> employees = new HashMap<String, EmployeeO2MPojo>();

	/**
	 * @return id: the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id: the id to set
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	

	/**
	 * @return deptName: the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName: the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return employees: the employees
	 */
	public Map<String, EmployeeO2MPojo> getEmployees() {
		return employees;
	}

	/**
	 * @param employees: the employees to set
	 */
	public void setEmployees(Map<String, EmployeeO2MPojo> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(String key, EmployeeO2MPojo employee) {
		employees.put(key, employee);
		employee.setType(key);
		employee.setDepartment(this);
	}

	public void deleteEmployee(EmployeeO2MPojo key) {
		employees.remove(key);
	}
}
