package com.interview.programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Naggaro {
	public static void main(String[] args) {

		System.out.println("TestTest.main()");
		String s1 = "Nitesh";
		int [] array = {1,2,3,4,5,6,7,8,9,10,12};
//		List<StringBuilder> list = new LinkedList<StringBuilder>();
		LinkedList<ArrayList<Integer>> list = new LinkedList<ArrayList<Integer>>();
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		
		int len = array.length;
		for (int i = 0; i < len; i++) {
			int count = len;
			int k = i + 1;
//			StringBuilder temp = null;
			List<Integer> temp = null;
			for (int j = i; j <= count; j++, k++) {
				j = i;
//				temp = new StringBuilder();
				temp = new ArrayList<Integer>();
				while (j < k) {
//					temp.append(s1.charAt(j));
					temp.add(array[j]);
					j++;
				}
				System.out.println(temp);
				if(isRequiredSum(temp)){
					set.add((ArrayList<Integer>) temp);
				}
				list.add((ArrayList<Integer>) temp);
			}
		}

		System.err.println("list : >> " + list);
		System.out.println("Set : >> " + set);
		
	}

	private static boolean isRequiredSum(List<Integer> temp) {
		System.err.println(temp);
		int sum = 0;
		for (Integer integer : temp) {
			sum += integer;
		}
		if(sum == 12)
			return true;
		return false;
	}

}