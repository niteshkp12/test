package com.test.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class java8ForEach {

	public static void main(String[] args) {
		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);

		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println("Iterator Value::" + i);
		}

		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("t: " + t);
			}
		});
		
		
		MyConsumer consumer = new MyConsumer();
		myList.forEach(consumer);
		
	}
	
	static class MyConsumer implements Consumer<Integer>{
		public void accept(Integer t) {
			System.err.println("T: " + t);
		}
		
	}
	

}
