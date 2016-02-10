package hibernate.bidirectional.m2m;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "m2m_department")
public class DepartmentM2MPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private Long id;

	@Column(name = "dept_name")
	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "m2m_emp_dept_join", joinColumns = @JoinColumn(name = "dept_id"), inverseJoinColumns = @JoinColumn(name = "emp_id"))
	private Set<EmployeeM2MPojo> employees = new HashSet<EmployeeM2MPojo>();

	public DepartmentM2MPojo() {
		super();
	}

	public DepartmentM2MPojo(String name) {
		super();
		this.name = name;
	}

	public Set<EmployeeM2MPojo> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeM2MPojo> employees) {
		if (this.employees != null && !this.employees.isEmpty()) {
			for (EmployeeM2MPojo item : this.employees) {
				item.getDepartments().remove(this);
			}
		}
		this.employees = employees;
		for (EmployeeM2MPojo employee : employees) {
			employee.getDepartments().add(this);
		}
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addEmployee(EmployeeM2MPojo employee) {
		employees.add(employee);
		employee.getDepartments().add(this);
	}
}