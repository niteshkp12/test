package com.test;

class AddressA {
	String city;
	String state;

	public AddressA(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AddressA() {
		super();
	}

	@Override
	public String toString() {
		return "Address: (" + city + " " + state + ")";
	}
}

class StudentA implements Cloneable {
	String name;
	int age;
	AddressA addressA;

	public StudentA(String name, int age, AddressA addressA) {
		super();
		this.name = name;
		this.age = age;
		this.addressA = addressA;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AddressA getAddressA() {
		return addressA;
	}

	public void setAddressA(AddressA addressA) {
		this.addressA = addressA;
	}

	public StudentA() {
		super();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
//		new CloneNotSupportedException();
		System.out.println("StudentA clone method");
		super.clone();
		AddressA address1 = new AddressA();
		address1.setCity(this.addressA.city);
		address1.setState(this.addressA.state);
		StudentA student1 = new StudentA();
		student1.setAddressA(address1);
		student1.setAge(this.age);
		student1.setName(this.name);
/*		AddressA address2 = new AddressA();
		address2.city = address1.city;
		address2.state = address1.state;
		String name = this.name;
		int age = this.age;
		StudentA studentA = new StudentA(name, age, address2);
*/		return student1;
	}

	@Override
	public String toString() {
		return "Name : " + name + " :: Age: " + age + " :: "
				+ addressA.toString();
	}
}

public class TestClone {
	public static void main(String[] args) {
		AddressA address1 = new AddressA("Indore", "MP");
		StudentA student1 = new StudentA("nitesh", 25, address1);
		StudentA student2 = null;
		try {
			if(student1 instanceof StudentA){
				student2 = (StudentA) student1.clone();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		student1.age = 26;
		student2.name = "rahul";
		student1.addressA.city = "Bhopal";
		student2.addressA.state = "CG";
		System.out.println(student1);
		System.out.println(student2);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		System.out.println("TestClone.clone()");
		return super.clone();
	}
}
