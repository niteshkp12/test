package com.test;

//Given a string, find out the lexicographically smallest and largest substring of length k.
public class TestLexicographic {
	public static void main(String[] args) {
		System.out.println("TestTest.main()");
		String temp = "welcometojava";
		int k = 3;
		int length = temp.length();
		String max = temp.substring(0, k);
		String min = max;
		if (length > k) {
			System.err.println(max);
			for (int i = 1; i <= length - k; i++) {
				String s = temp.substring(i, i + k);
				System.out.println(s);
				if (s.compareTo(max) > 0) {
					max = s;
					System.out.println("max :" + max);
				} else if (min.compareTo(s) > 0) {
					min = s;
					System.out.println("min :" + min);
				}
			}

		}

		System.err.println("Max: >>> " + max);
		System.err.println("Min: >>> " + min);

	}
}