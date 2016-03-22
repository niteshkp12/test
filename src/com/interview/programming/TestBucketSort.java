package com.interview.programming;

//Given a collection of 1 million integers ranging from 1 to 9, how would you sort them in Big O(n) time ?
public class TestBucketSort {
	public static void main(String[] args) {
		System.out.println("TestBucketSort.main()");
		int array[] = { 1, 9, 3, 6, 4, 1, 5, 9, 6, 1, 7, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 5, 9, 8, 5, 3, 2, 6, 7, 8, 4,
				2 };
		int[] sorted = bucketSort(array, 1, 9);
		System.out.println(sorted.toString());
		for (int i = 0; i < sorted.length; i++) {
			for (int j = 0; j < sorted[i]; j++) {
				System.err.print(i + 1 + " ");
			}
		}
	}

	private static int[] bucketSort(int[] array, int min, int max) {
		int sort[] = new int[max - min + 1];
		for (int k = 0; k < array.length; k++) {
			System.out.println("array : " + array[k]);
			sort[array[k] - 1]++;
		}
		return sort;
	}
}
