/**
 * @file: EmployeeO2MPojo.java
 * @project: Hibernate102Assesment
 * @package: hibernate.o2o.pojo
 * @author: smahe2
 * @created: Sep 26, 2011 6:59:46 PM
 */
package hibernate.bidirectional.o2m;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @type EmployeeO2MPojo
 * @author smahe2
 * @project Hibernate102Assesment
 * @package hibernate.o2o.pojo
 * @file EmployeeO2MPojo.java
 */
@Entity
@Table(name = "o2m_employee")
public class EmployeeO2MPojo {
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
	@Column(name="first_name")
	private String firstName;
	
	/**
	 *@field lastName
	 *@type String 
	 */
	@Column(name="last_name")
	private String lastName;
	
	/**
	 *@field type
	 *@type String 
	 */
	@Basic
	private String type;
	
	/**
	 *@field item
	 *@type DepartmentO2MPojo 
	 */
	@ManyToOne
	private DepartmentO2MPojo department;
	
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
	 * @return type: the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type: the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return department: the department
	 */
	public DepartmentO2MPojo getDepartment() {
		return department;
	}

	/**
	 * @param department: the department to set
	 */
	public void setDepartment(DepartmentO2MPojo department) {
		this.department = department;
	}

	
}
