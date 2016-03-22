package com.test;

public class TestOverloading {

	public void TestOverloading() {
		System.out.println("TestOverloading.TestOverloading()");
	}

	public static void main(String[] args) {
		System.out.println("TestOverloading.main()");
		TestOverloading t = new TestOverloading();
		t.TestOverloading();

		StringBuffer s1 = new StringBuffer("GolCondaFort");
		System.err.println(s1);
		System.err.println(s1.capacity());
		System.err.println(s1.length());

		BA aa = new BA();
		aa.getMethod();

	}

}

class AA {

	public AA() {
		System.out.println("AA.AA()");
	}

	protected Number getMethod() {
		System.out.println("AA.getMethod()");
		return null;
	}

}

class BA extends AA {
	@Override
	public Integer getMethod() {
		System.out.println("AA.getMethod()");
		return null;
	}
	
	public BA() {
		System.out.println("BA.BA()");
	
	}
}
