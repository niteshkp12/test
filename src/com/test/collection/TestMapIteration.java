package com.test.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMapIteration {
	public static void main(String[] args) {
		System.out.println("TestMapIteration.main()");
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "one");
		map.put("2", "Two");
		map.put("3", "Three");
		map.put("4", "Four");
		System.err.println(map);

		// for loop using entrySet
		// Other way can be using iterator
		Set<Map.Entry<String, String>> entries = map.entrySet();
		for (Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + " :: " + entry.getValue());
		}

		// iterating using keyset
		// other way can be using for loop
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.err.println(key + " :: " + map.get(key));
		}

	}
}
