package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*also see KeyboardRow,TenLineTemplateForStringProblem*/
public class FirstUniqueChar {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("lleetcode"));

	}

	// my solution
	public static int firstUniqChar(String s) {
		// Leetcode don't accept this solution, Limited Time error, change map
		// to int[] array with 256 size works
		HashMap<Character, Integer> orderedMap = new LinkedHashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (orderedMap.containsKey(c)) {
				orderedMap.put(c, orderedMap.get(c) + 1);
			} else {
				orderedMap.put(c, 1);
			}
		}
		for (int i = 0; i < s.toCharArray().length; i++) {
			if (orderedMap.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static int firstUniqChar2(String s) {
		int[] frequency = new int[256];// size of the frequency array to 256 to
										// store other kinds of characters.
		char[] charArr = s.toCharArray();
		for (char c : charArr) {
			frequency[c] = ++frequency[c];
		}
		for (int i = 0; i < charArr.length; i++) {
			if (frequency[charArr[i]] == 1) {
				return i;
			}
		}
		return -1;
	}
}
