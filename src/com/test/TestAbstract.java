package com.test;

abstract class Abstract1 {
	
	public Abstract1() {
		super();
		System.err.println("Nitesh");
	}

	private void test(){
		
	}
	void method1() {
		System.out.println("Abstract1.method1()");
	}
	
}

public class TestAbstract {
	public static void main(String[] args) {
		System.out.println("TestAbstract.main()");
		Abstract1 a = new Abstract1(){};

	}
}
