package com.interview.programming;

public class TestPallindrome {

	static int sum = 0;

	public static void main(String[] args) {
		String s = "mad  f  dam";
		System.out.println(isPallindromeString(s));
		int number = 12321;

		try {
		} catch (Exception e) {
		}
		finally {
		}
		String s2 = number + "";
		System.out.println("Test " + s2 + " :: " + isPallindromeString(s2));
		isPallindromeNumber(number);
		System.out.println(sum);
		if (sum == number) {
			System.out.println("pallindrome");
		}
	}

	private static void isPallindromeNumber(int i) {
		if (i != 0) {
			int rem = i % 10;
			sum = sum * 10 + rem;
			i = i / 10;
			isPallindromeNumber(i);
		}
		return;
	}

	private static boolean isPallindromeString(String s) {
		char[] chars = s.toCharArray();
		int len = chars.length;
		for (int i = 0, n = len - 1; i < len / 2; i++, n--) {
			if (chars[i] != chars[n]) {
				System.out.println(chars[i] + " : : " + chars[n]);
				return false;
			}
		}
		return true;
	}
}
