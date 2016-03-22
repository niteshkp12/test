package com.test.collection;

import java.util.ArrayList;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(4);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		System.out.println(arrayList);
		arrayList.remove(2);
		System.out.println(arrayList.toString());
	}
}
