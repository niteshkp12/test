package hibernate.bidirectional.m2m;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "m2m_employee")
public class EmployeeM2MPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long id;

	@Column(name = "first_name", nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "employees", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<DepartmentM2MPojo> departments = new HashSet<DepartmentM2MPojo>();

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

	public Set<DepartmentM2MPojo> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<DepartmentM2MPojo> departments) {
		if (this.departments != null && !this.departments.isEmpty()) {
			for (DepartmentM2MPojo category : this.departments) {
				category.getEmployees().remove(this);
			}
		}
		this.departments = departments;
		for (DepartmentM2MPojo category : departments) {
			category.getEmployees().add(this);
		}
	}
}