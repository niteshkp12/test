package com.interview.programming;

public class TestStringPermutation {

	private static boolean[] used;
	private static StringBuilder out = new StringBuilder();
	private static int count;

	public static void main(String[] args) {
		System.out.println("TestStringPermutation.main()");
		String s = "rame";
		used = new boolean[s.length()];
		int n = findPermutation(s);
	}

	private static int findPermutation(String s) {
		int len = s.length();

		if (out.length() == s.length()) {
			System.out.println(count++ + " :: " + out);
		}

		for (int i = 0; i < len; i++) {
			if (used[i])
				continue;

			out.append(s.charAt(i));
			used[i] = true;

			findPermutation(s);
			used[i] = false;
			out.setLength(out.length() - 1);

		}

		return 0;
	}

}
