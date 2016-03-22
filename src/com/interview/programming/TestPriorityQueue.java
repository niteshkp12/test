package com.interview.programming;

import java.util.PriorityQueue;

//Find 5 largest from the list of million numbers
public class TestPriorityQueue {
	public static void main(String[] args) {
		System.out.println("TestPriorityQueue.main()");
		int[] numbers = { 2, 34, 45, 54, 5, 3, 4, 3, 433, 43242, 3, 42432, 4324, 3434, 344, 3 };

		Integer[] largestNumber = getLargestNumber(numbers);
		System.err.println(largestNumber);
	}

	private static Integer[] getLargestNumber(int[] numbers) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(5);
		for (int i = 0; i < numbers.length; i++) {
			if (queue.size() < 5) {
				queue.add(new Integer(numbers[i]));
			}else{
				System.err.println(queue.peek());
				if(queue.peek() < numbers[i]){
					queue.remove();
					queue.add(numbers[i]);
				}
			}
		}
		System.err.println(queue);
		return null;
	}
}
