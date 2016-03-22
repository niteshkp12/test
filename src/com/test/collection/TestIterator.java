package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

	public static void main(String[] args) {
		// MethodSet();
		MethodList();
	}

	public static void MethodList() {
		ArrayList<String> arrayList = new ArrayList<String>(4);
		List<String> list = Collections.synchronizedList(arrayList);
		// CopyOnWriteArrayList<String> arrayList = new
		// CopyOnWriteArrayList<String>();

		arrayList.add("Nitesh");
		arrayList.add("Kumar");
		arrayList.add("prajapati");
		arrayList.add("Nitesh");

		System.err.println(arrayList);

		// Iterator<String> iterator = arrayList.iterator();
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String temp = iterator.next();
			if (temp.equals("Nitesh")) {
//				 iterator.remove();
//				arrayList.remove(temp);
			}
		}
		System.out.println(arrayList);
		for(String string : arrayList){
			arrayList.remove(0);
		}
		System.out.println(arrayList);
	}

}
