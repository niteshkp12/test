/**
 * @file: EmployeeO2MPojo.java
 * @project: Hibernate102Assesment
 * @package: hibernate.o2o.pojo
 * @author: smahe2
 * @created: Sep 26, 2011 6:59:46 PM
 */
package hibernate.bidirectional.o2o;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @type EmployeeO2MPojo
 * @author smahe2
 * @project Hibernate102Assesment
 * @package hibernate.o2o.pojo
 * @file EmployeeO2MPojo.java
 */
@Entity
@Table(name = "o2o_employee")
public class EmployeeO2OPojo {
	/**
	 *@field id
	 *@type Long 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 *@field firstName
	 *@type String 
	 */
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	/**
	 *@field lastName
	 *@type String 
	 */
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	/**
	 *@field department
	 *@type DepartmentO2MPojo 
	 */
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "department_id")
	private DepartmentO2OPojo department;

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
	 * @return firstName: the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName: the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName: the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName: the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return department: the department
	 */
	public DepartmentO2OPojo getDepartment() {
		return department;
	}

	/**
	 * @param department: the department to set
	 */
	public void setDepartment(DepartmentO2OPojo department) {
		this.department = department;
	}
	
	
}
