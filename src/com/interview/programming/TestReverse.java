package com.interview.programming;

public class TestReverse {
	public static void main(String[] args) {
		System.out.println(reverseRecursively("Nitesh"));
	}

	public static String reverseRecursively(String str) {
		if (str.length() < 2) {
			return str;
		}
		return reverseRecursively(str.substring(1)) + str.charAt(0);
	}

}
