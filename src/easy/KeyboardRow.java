package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeyboardRow {

	public static void main(String[] args) {
		String[] input = new String[] { "Hello", "Alaska", "Dad", "Peace" };
		String[] input1 = new String[] { "a", "b" };
		System.out.println(Arrays.toString(findWords(input1)));

	}

	// my solution
	public static String[] findWords(String[] words) {
		// Define constant variable
		HashSet<Character> row1 = new HashSet<Character>(
				Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
		HashSet<Character> row2 = new HashSet<Character>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
		HashSet<Character> row3 = new HashSet<Character>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		for (String s : words) {
			if (containsAll(row1, s.toLowerCase())) { // 1. here I forget to
														// lowercase the string
				list1.add(s);
			} else if (containsAll(row2, s.toLowerCase())) {
				list2.add(s);
			} else if (containsAll(row3, s.toLowerCase())) {
				list3.add(s);
			}
		}
		if (list1.size() > 0) {
			return list1.toArray(new String[list1.size()]);
		} else if (list2.size() > 0) {
			return list2.toArray(new String[list2.size()]);
		} else if (list3.size() > 0) {
			return list3.toArray(new String[list3.size()]);
		} else {
			return null;
		}

	}

	public static boolean containsAll(Set<Character> charSet, String s) {
		boolean result = true;
		for (char c : s.toCharArray()) {
			if (!charSet.contains(c)) {
				result = false;
				break;// 2, here forget that can break this for loop once find a
						// char is not in set
			}
		}
		return result;
	}

	// other's solution
	public String[] findWords1(String[] words) {
		List<String> result = new ArrayList<String>();
		String[] strs = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			for (char c : strs[i].toCharArray()) {
				map.put(c, i);
			}
		}
		int index = 0;
		for (String s : words) {
			index = map.get(s.toUpperCase().charAt(0));
			for (char c : s.toUpperCase().toCharArray()) {
				if (map.get(c) != index) {
					index = -1;
				}
			}
			if (index != -1)
				result.add(s);
		}

		return result.toArray(new String[0]);

	}

}
