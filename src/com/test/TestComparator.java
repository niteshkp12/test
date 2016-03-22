package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class MyNameCompartor implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		System.out.println("MyNameCompartor.compare()" + o1 + o2);
		System.out.println(o1.getName().compareTo(o2.getName()) );
		System.out.println(o1.getName().compareTo(o2.getName()));
		return o1.getName().compareTo(o2.getName());
	}
	
}
public class TestComparator {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		Person person1 = new Person(12, "nitesh");
		Person person2 = new Person(2, "Kumar");
		Person person3 = new Person(3, "rahul");
		Person person4 = new Person(12, "nitesh");
		System.out.println(person1.equals(person4));
		
//		Set<Person> set = new HashSet<>();
//		set.add(person4);
//		set.add(person1);
//		System.out.println(set);
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		
		System.err.println(persons);

		Collections.sort(persons);
		
		System.out.println(persons);
		
		Collections.sort(persons, new MyNameCompartor());
		System.err.println(persons);
		
		
		
	}
}
