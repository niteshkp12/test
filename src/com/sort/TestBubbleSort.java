package com.sort;

public class TestBubbleSort {
	public static void main(String[] args) {
		System.out.println("TestBubbleSort.main(   )");
		int a[] = { 1, 2, 4, 23, 54, 65, 12, 6, 54876, 44 };

		int n = a.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n-i); j++) {
				if (a[j-1] > a[j]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
//			System.err.println(a[i]);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}

	}
}
