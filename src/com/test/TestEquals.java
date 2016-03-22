package com.test;

class EqualA {
	String name;

	public EqualA(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqualA other = (EqualA) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}

public class TestEquals {
	public static void main(String[] args) {
		System.out.println("TestEquals.main()");

		EqualA a = new EqualA("Nitesh");
		EqualA b = new EqualA("Nitesh");
		System.err.println(a.equals(b));
		System.err.println(a==b);
		System.out.println(a.toString());
	}
}
