package com.test.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


class ListComparable implements Comparable<String>{

	@Override
	public int compareTo(String o) {
		return 0;
	}
	
}

public class TestList extends ArrayList implements Serializable {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		System.out.println("nitesh");
		List<String> list = new LinkedList<String>();
		list.add("Nitesh");
		list.add("Kumar");
		list.add("Kumar2");
		list.add("Kumar3");
		System.out.println(list);

		// list = list.subList(1, 3);
		System.out.println(0x7fffffff);

		FileOutputStream out = new FileOutputStream("Hello.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		objectOutputStream.writeObject(list);

		FileInputStream fileInputStream = new FileInputStream("Hello.ser");
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		Object object = inputStream.readObject();
		System.out.println(object);

		String s1 = "nitesh";
		String s2 = "nitesh";
		String s3 = new String("nitesh");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		list.add("null");
		list.add("null");
		list.add("Kumar");
		System.out.println(list);
		sort(list);
		System.out.println(list);

		System.out.println(10 >> 1);
		
	}

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        System.out.println("niteshkp");
    	Object[] a = list.toArray();
    	System.out.println("fdsadf" + a.toString());
        Arrays.sort(a);
        System.err.println(a.toString());
        ListIterator<T> i = list.listIterator();
        for (int j=0; j<a.length; j++) {
            i.next();
            i.set((T)a[j]);
            i.set((T) "ites");
        }
    }

}
