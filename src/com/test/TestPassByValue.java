package com.test;

class EmployeeByVlaue {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print(String s) {
		s = "Suraj";
		System.err.println("EmployeeByVlaue.print() ____ " + name);
	}

	public EmployeeByVlaue(String name) {
		super();
		this.name = name;
	}
	
}

public class TestPassByValue {
	public static void main(String[] args) {
		System.out.println("TestPassByValue.main()");

		String naam = "nitesh";
		EmployeeByVlaue e = new EmployeeByVlaue(naam);
		e.print(naam);
		
		System.out.println("Naam = " + naam);
	}

}
