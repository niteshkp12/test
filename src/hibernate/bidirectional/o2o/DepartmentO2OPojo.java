/**
 * @file: DepartmentO2MPojo.java
 * @project: Hibernate102Assesment
 * @package: hibernate.o2o.main
 * @author: smahe2
 * @created: Sep 26, 2011 7:06:54 PM
 */
package hibernate.bidirectional.o2o;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @type DepartmentO2MPojo
 * @author smahe2
 * @project Hibernate102Assesment
 * @package hibernate.o2o.main
 * @file DepartmentO2MPojo.java
 */
@Entity
@Table(name="o2o_department")
public class DepartmentO2OPojo {
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
	@Column(name="dept_name", nullable = false)
	private String deptName;

	/**
	 *@field employee
	 *@type EmployeeO2MPojo 
	 */
	@OneToOne(mappedBy="department")
	private EmployeeO2OPojo employee;

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
	 * @return employee: the employee
	 */
	public EmployeeO2OPojo getEmployee() {
		return employee;
	}

	/**
	 * @param employee: the employee to set
	 */
	public void setEmployee(EmployeeO2OPojo employee) {
		this.employee = employee;
	}
}
