package com.interview.programming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		System.out.println("FirstNonRepeatedChar.main()");
		String s = "My name is nitesh";
		char c = findFirstNonRepeatedChar(s.toLowerCase());
		System.out.println("c: " + c);
	}

	private static char findFirstNonRepeatedChar(String s) {
		int len = s.length();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (" ".equals(String.valueOf(c))) {
				continue;
			}
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		System.err.println(map);

		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		for (Map.Entry<Character, Integer> map2 : set) {
			if (map2.getValue() == 1) {
				return map2.getKey();
			}
		}

		return 0;
	}

}
