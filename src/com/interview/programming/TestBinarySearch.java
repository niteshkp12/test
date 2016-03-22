package com.interview.programming;

public class TestBinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int low = 0;
		int high = a.length - 1;
		int mid = (low + high) / 2;
		System.out.println(a[7]);

		int b = a[7];

		while (low <= high) {
			if (b > a[mid]) {
				low = mid + 1;
				mid = (low + high) / 2;
			} else {
				high = mid - 1;
				mid = (low + high) / 2;
			}
		}
		System.out.println(a[mid]);
	}

}
