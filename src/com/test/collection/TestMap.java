package com.test.collection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

class Weekday {
	String day;
	int time;

	public Weekday(String day) {
		super();
		this.day = day;
	}

	@Override
	public String toString() {
		return "Weekday [day=" + day + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + time;
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
		Weekday other = (Weekday) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (time != other.time)
			return false;
		return true;
	}

}

class Employee implements Serializable {
	private String name;

	public Employee(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/

}

public class TestMap {
	public static void main(String[] args) {
		Method();
	}

	static void Method() {
		Map<Weekday, Integer> map = new HashMap<Weekday, Integer>();
		Weekday w1 = new Weekday("Monday");
		Weekday w2 = new Weekday("Monday");
		map.put(w1, 1);
		map.put(w2, 2);
		map.put(null, 1);
		map.put(null, 2);

		System.err.println(map);

		differentMap();

		// testMapCapacity();

	}

	private static void testMapCapacity() {
		CustomMap<Employee, String> customMap = new CustomMap<>(2);

		System.out.println("Print CustomMap: \t" + customMap);
		for (int i = 0; i < 15; i++) {
			customMap.put(new Employee("Nitesh" + i), i + "");

		}
		System.out.println("Print CustomMap: \t" + customMap);
	}

	public static void differentMap() {
		Map<String, Integer> map1 = Collections.synchronizedMap(new HashMap<String, Integer>());
		Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();
		Map<String, Integer> map3 = new TreeMap<String, Integer>();
		Map<String, Integer> map4 = new ConcurrentHashMap<String, Integer>();
		Map<Employee, String> map5 = new CustomMap<>(1);
		Map<String, Integer> map6 = new WeakHashMap<>();

		map5.put(new Employee("nitesh1"), "Kumar1");
		Employee employee = new Employee("nitesh1");
		map5.put(new Employee("nitesh1"), "Kumar2");
		map5.put(employee, "n");
		System.err.println(map5);

		System.out.println("get map: " + map5.get(employee));
		String[] string = new String[] { "mango", "apple", "grapes", "banana" };

		String str = new String("temp");
		String strWeak = new String("strWeak");
		map1.put(str, 10);
		map6.put(strWeak, 10);
		for (int i = 0; i < string.length; i++) {
			map1.put(string[i], i);
			// map.put(i+"", i);
			map2.put(string[i], i);
			map3.put(string[i], i);
			map4.put(string[i], i);
			map6.put(string[i], i);
		}
		System.out.println("hashMap: 	" + map1);
		System.out.println("LinkedhashMap: 	" + map2);
		System.out.println("TreehashMap: 	" + map3);
		System.out.println("ConcurrentMap: 	" + map4);
		System.out.println("CustomMap: 	" + map4);
		System.out.println("WeakMap: 	" + map6);

		System.gc();

		System.out.println("hashMap: 	" + map1.get(str));
		System.out.println("WeakMap: 	" + map6.get(strWeak));

		str = null;
		strWeak = null;
		System.gc();

		System.err.println(16 >> 1);

		System.out.println("hashMap: 	" + map1.get("temp"));
		System.out.println("WeakMap: 	" + map6.get("strWeak"));

		System.out.println("2 << 3");

		File file = new File("customMap.ser");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
			objectOutput.writeObject(map5);
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.err.println("map4 >>>>>> " + map4);
		Iterator<Entry<String, Integer>> iterator = map4.entrySet().iterator();
		while (iterator.hasNext()) {

			System.out.println(iterator.next());
			map4.remove(iterator.next());
			iterator.remove();
		}
		System.err.println("map4 >>>>>> " + map4);

	}
}
