package com.test.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Java program to demonstrate difference between TreeSet, HashSet and
 * LinkedHashSet in Java Collection.
 * 
 * @author
 */

class MyComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		// System.err.println(o1 + ".compareTo("+ o2 + " :: " + o1.compareTo(o2)
		// + " :: " + o1.hashCode() + " :: " + o2.hashCode() + " :: " +
		// (o1.hashCode()-o2.hashCode()));
		String s1 = o1.toString();
		String s2 = o2.toString();

		return s1.compareTo(s2);
	}

}

public class TestSet {

	public static void main(String args[]) throws InterruptedException {
		HashSet<String> fruitsStore = new HashSet<String>(4, (float) 2568);
		// ConcurrentSkipListSet<String> fruitsStore = new
		// ConcurrentSkipListSet<String>();
		LinkedHashSet<String> fruitMarket = new LinkedHashSet<String>();
		TreeSet fruitBuzz = new TreeSet(new MyComparator());

		for (String fruit : Arrays.asList("mango", "apple", "banan", "grape",
				"chiku", "anara")) {
			fruitsStore.add(fruit);
			fruitMarket.add(fruit);
			fruitBuzz.add(fruit);
		}

		fruitBuzz.add(new StringBuffer("asdfg"));
		fruitBuzz.add(new StringBuilder("asdfg"));
		// no ordering in HashSet � elements stored in random order
		System.out.println("Ordering in HashSet 		:" + fruitsStore);

		// insertion order or elements � LinkedHashSet storeds elements as
		// insertion
		System.err.println("Order of element in LinkedHashSet :" + fruitMarket);

		// should be sorted order � TreeSet stores element in sorted order
		System.out.println("Order of objects in TreeSet 	:" + fruitBuzz);

		// Performance test to insert 10M elements in HashSet, LinkedHashSet and
		// TreeSet
		Set<Integer> numbers = new HashSet<Integer>();
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			numbers.add(i);
		}

		long endTime = System.nanoTime();
		System.out
				.println("Total time to insert 10M elements in HashSet in sec : "
						+ (endTime - startTime) / 1000);

		// LinkedHashSet performance Test � inserting 10M objects
		numbers = new LinkedHashSet<Integer>();
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			numbers.add(i);
		}
		endTime = System.nanoTime();
		System.out
				.println("Total time to insert 10M elements in LinkedHashSet in sec : "
						+ (endTime - startTime) / 1000);

		// TreeSet performance Test � inserting 10M objects
		numbers = new TreeSet<Integer>();
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			numbers.add(i);
		}
		endTime = System.nanoTime();
		System.out
				.println("Total time to insert 10M elements in TreeSet in sec : "
						+ (endTime - startTime) / 1000);
	}
}
