package com.interview.programming;

import java.util.Scanner;

public class TestFibancai {

	public static void main(String[] args) {
		findFibonacci(7);
		System.out.println("\n_________________________");

		// Using recursion
		int number = new Scanner(System.in).nextInt();
		for (int i = 0; i < number; i++) {
			System.out.print(findFibonacciRecursion(i) + " ");
		}
	}

	public static int findFibonacciRecursion(int number) {
		if (number == 0)
			return 0;
		if (number == 1 || number == 2) {
			return 1;
		}

		return findFibonacciRecursion(number - 1)
				+ findFibonacciRecursion(number - 2);
	}

	private static void findFibonacci(int number) {
		int a = 0, b = 1, c = 1;
		System.out.print(a + " " + b + " " + c + " ");
		for (int j = 0; j < number; j++) {
			c = b + c;
			b = c - b;
			System.out.print(c + " ");
		}
	}

}
