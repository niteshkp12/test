package com.test;

//Instance method of the calling class always get called

class Aaa {
	private String temp;
	Aaa() {
		System.out.println("Aaa.Aaa()");
		greeting();
		prints();
	}
	

	void greeting() {
		System.out.println("instance method from A");
	}

	static void prints() {
		System.out.println("Static method from A");
	}
}

class Bbb extends Aaa {
	Bbb() {
		// super();
		System.out.println("Bbb.Bbb()");
		greeting();
		prints();
	}

	void greeting() {
		System.out.println("instance method from B");
	}

	static void prints() {
		System.out.println("Static method from B");
	}
}

class TestConstructor {
	public static void main(String[] args) {
		System.out.println("Test.main()");
		// new Bbb();
		new Ccc();
	}
}

class Ccc extends Bbb {
	Ccc() {
		// super();
		System.out.println("Ccc.Ccc()");
		greeting();
		prints();
	}

	void greeting() {
		System.out.println("instance method from C");
	}

	static void prints() {
		System.out.println("Static method from C");
	}
}