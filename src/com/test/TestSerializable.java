package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class AddressSerializable implements Serializable {
	private static final long serialVersionUID = 1L;
	int homeNo;
	String street;
	String city;

	public AddressSerializable(int homeNo, String street, String city) {
		super();
		System.out.println("AddressSerializable.AddressSerializable()");
		this.homeNo = homeNo;
		this.street = street;
		this.city = city;
	}

	private AddressSerializable() {
		System.out.println("no arg constructor");
	}

	public int getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AddressSerializable [homeNo=" + homeNo + ", street=" + street
				+ ", city=" + city + "]";
	}

}

class EmployeeSerializable implements Serializable {
	private static final long serialVersionUID = 1L;
	int employeeId;
	transient String employeeName;
	String lastName;
	AddressSerializable address;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmployeeSerializable() {
		System.out.println("no arg Employee constructor");
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public AddressSerializable getAddress() {
		return address;
	}

	public void setAddress(AddressSerializable address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeSerializable [employeeId=" + employeeId
				+ ", employeeName=" + employeeName + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}

	/*
	 * private void writeObject(ObjectOutputStream outputStream) throws
	 * IOException { // outputStream.defaultWriteObject();
	 * outputStream.writeInt(employeeId);
	 * outputStream.writeObject(employeeName); //
	 * outputStream.writeObject(department);
	 * outputStream.writeObject(address.city);
	 * 
	 * // outputStream.close(); }
	 * 
	 * private void readObject(ObjectInputStream inputStream) throws
	 * ClassNotFoundException, IOException { // inputStream.defaultReadObject();
	 * this.employeeId = inputStream.readInt(); this.employeeName = (String)
	 * inputStream.readObject(); // this.department = (String)
	 * inputStream.readObject(); String city = (String)
	 * inputStream.readObject(); this.address = new AddressSerializable();
	 * this.address.setCity(city);
	 * 
	 * EmployeeSerializable emp = new EmployeeSerializable();
	 * emp.setEmployeeId(employeeId); emp.setEmployeeName(employeeName); //
	 * emp.setDepartment(department);
	 * 
	 * System.err.println("emp-------------- >> " + emp);
	 * 
	 * System.out.println("EmployeeSerializable.readObject()"); }
	 */
}

public class TestSerializable {
	public static void main(String[] args) {

		EmployeeSerializable emp = new EmployeeSerializable();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Arpit");
		// emp.setDepartment("CS");
		AddressSerializable address = new AddressSerializable(88, "MG road",
				"Pune");
		emp.setAddress(address);

		System.err.println("Serialized Employee... ======== >> " + emp);
		System.err.println("emp Hashcode: " + emp.hashCode());
		// Serialize
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// Deserialize
		 emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (EmployeeSerializable) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
	

		System.out.println("Deserialized Employee... ======== >> " + emp);
		System.out.println("Emp2 hashcode " + emp.hashCode());
	}
}
