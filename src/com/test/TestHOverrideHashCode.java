package com.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.test.collection.CustomMap;


class Person implements Comparable<Person> {
	int id;
	String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
		return 12345;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nId: " + id + " :: Name: " + name + ", hashcode: " + this.hashCode();
	}

	@Override
	public int compareTo(Person o) {
		int temp = o.id - this.id;
		System.err.println("Person: " + o + "_________" + this);
		System.out.println("__ " + temp);

		return temp;
	}

}

public class TestHOverrideHashCode {
	public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		Person person4 = new Person();
		Person person5 = new Person();
		
		Set<Person> set = new HashSet<Person>();
		set.add(person1);
		set.add(person2);
		set.add(person3);
		set.add(person4);
		set.add(person5);

		System.out.println(set);
		
		Map<Person, Integer> map = new CustomMap(); 
		map.put(person1,1);
		person1.setId(1);
		person1.setName("nitesh");
		map.put(person1, 2);
		map.put(person2,1);
		map.put(person3,1);
		map.put(person4,1);
		map.put(person5,1);
		

		System.out.println("Person: " + map);
		System.out.println("Person: " + map.get(person1));
		System.out.println("Person: " + map.get(person2));
		System.out.println("Person: " + map.get(new Person()));
		
		System.err.println("Person1 hashcode(): " + person1.hashCode());
		System.err.println("Person2 hashcode(): " + person2.hashCode());
		person1.setId(10);
		person2.setId(10);
		person1.setName("nitesh");
		person2.setName("nitesh");

		// If we don't override hashcode, we can add both person1 and person2 to
		// the set
		// even though both object are same.
		Set<Person> persons = new HashSet<Person>();
		persons.add(person2);
		persons.add(person1);

//		System.out.println(persons);
//		System.err.println("Person1 hashcode(): " + person1.hashCode());
//		System.err.println("Person2 hashcode(): " + person2.hashCode());

		// If we don't override equals method, then person1 and person2 will
		// always be different
		// even though both contains the exactly same value;
//		System.out.println(person1.equals(person2));
	}
}
