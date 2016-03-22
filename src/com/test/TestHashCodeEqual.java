package com.test;

import java.util.HashMap;
import java.util.HashSet;

//class Person {
//	private String id;
//	private String name;
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//}

public class TestHashCodeEqual {

	public static void main(String[] args) {
		System.out.println("TestHashCodeEqual.main()");
		Person person1 = new Person();
		Person person2 = new Person();
		person1.hashCode();
		HashSet<Person> hashSet = new HashSet<Person>();

		person1.setId(10);
		person2.setId(10);
		hashSet.add(person1);
		hashSet.add(person2);

		System.out.println(person1.equals(person2));
		System.out.println("hashSet :: " + hashSet);

		HashMap<Person, Integer> hashMap = new HashMap<Person, Integer>();
		hashMap.put(person1, 1);
		hashMap.put(person2, 2);
		System.err.println(hashMap);
	}
}
