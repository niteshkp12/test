package com.test;

import java.util.ArrayList;
import java.util.List;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class TestGenerics {
	public static void main(String[] args) {
		System.out.println("TestGenerics.main()");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		List<Float> listf = new ArrayList<Float>();
		for (float i = 0; i < 10; i++) {
			listf.add(i);
		}
		Method(list);
		Method(listf);
		
		Method1(list);
System.err.println(list);
	}

	static void Method(List<? extends Number> list) {
		for (Number list1 : list) {
			System.out.println(list1);
			// Extends doesn't allow add because ? extends Number can be
			// anything e.g. integer, float etc
//			 list.add(1);
		}
	}

	static void Method1(List<? super Integer> list) {
		for (Object list1 : list) {
			System.out.println(list1);
			list.add(1);
		}
		
		list.add(100);
	}
}

class Holder<T> {
	private T[] contents;
	private int index = 0;

	public Holder(T[] contents) {
		contents = (T[]) new Object[10];
	}

	public T getContents() {
		return contents[index];
	}

	public void setContents(T[] contents) {
		this.contents = contents;
	}

}