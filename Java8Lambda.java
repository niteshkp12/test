package com.test.java8;

interface SingleMethodInterface {
	public void method(String str);
}

public class Java8Lambda {

	public static void main(String[] args) {
		System.out.println("Java8Lambda.main()12");

		SingleMethodInterface SingleMethodInterface1 = new SingleMethodInterface() {
			@Override
			public void method(String string) {
				System.out.println("SingleMethodInterface1");
			}
		};

		SingleMethodInterface SingleMethodInterface2 = (string) -> {
			System.out.println("SingleMethodInterface2");
		};

		SingleMethodInterface SingleMethodInterface3 = (Object) -> System.err.println("SingleMethodInterface3");

		SingleMethodInterface1.method("SingleMethodInterface1");
		SingleMethodInterface2.method("SingleMethodInterface2");
		SingleMethodInterface3.method("SingleMethodInterface3");
	}

}
