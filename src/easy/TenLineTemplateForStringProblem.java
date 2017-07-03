package easy;

import java.util.ArrayList;
import java.util.List;

public class TenLineTemplateForStringProblem {

	public static void main(String[] args) {
		System.out.println(findAnagrams2("abcdabcda", "abc"));

	}
	// public String minWindow(String s, String t) {
	// int[] map = new int[128];
	// for(char c: t.toCharArray()) map[c]++;
	// int counter=toString().length(), begin=0, end=0, d=Integer.MAX_VALUE,
	// head=0;
	// while(end<s.length()){
	// if(map[s[end++]]-->0) counter--; //in t
	// while(counter==0){ //valid
	// if(end-begin<d) d=end-(head=begin);
	// if(map[s[begin++]]++==0) counter++; //make it invalid
	// }
	// }
	// return d==INT_MAX? "":s.substr(head, d);
	// }

	public static int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];
		int counter = 0, begin = 0, end = 0, d = 0;
		while (end < s.length()) {
			if (map[s.charAt(end++)]++ > 0)
				counter++;
			while (counter > 0)
				if (map[s.charAt(begin++)]-- > 1)
					counter--;
			d = Math.max(d, end - begin); // while valid, update d
		}
		return d;

	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
		int[] hash = new int[256]; // character hash
		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right++)]-- >= 1)
				count--;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0)
				list.add(left);

			// if we find the window's size equals to p, then we have to move
			// left (narrow the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't
			// go below 0
			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
				count++;
		}
		return list;
	}

	public static List<Integer> findAnagrams1(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		int[] map = new int[128];
		for (char c : p.toCharArray()) {
			map[c]++;// suppose p is abc, map would be (a,1)(b,1)(c,1);
		}
		int i = 0, np = p.length(), ns = s.length();

		while (i <= ns - np) {
			boolean success = true;
			int[] temp = map.clone();
			for (int j = i; j < i + np; j++) {
				System.out.println(temp[s.charAt(j)]);
				if (--temp[s.charAt(j)] < 0) {
					success = false;
					break;
				}
			}
			if (success)
				result.add(i);
			i++;
		}
		return result;
	}

	// Sliding window
	public static List<Integer> findAnagrams2(String s, String p) {
		if (s == null || s.length() == 0)
			return null;
		List<Integer> result = new ArrayList<Integer>();
		int[] map = new int[128];
		for (char c : p.toCharArray()) {
			map[c]++;// suppose p is abc, map would be (a,1)(b,1)(c,1);
		}
		int left = 0, right = 0, cnt = p.length(), n = s.length();
		while (right < n) {
			if (map[s.charAt(right++)]-- >= 1) { // this is the point ,put ++ --
													// in if condition, this ++
													// -- will execute anytime,
													// put inside, only execute
													// when condition is true
				cnt--;
			}
			if (cnt == 0)
				result.add(left);// all chars in string p matches

			// if the difference of right - left is size of string p, should
			// move left
			if (right - left == p.length() && map[s.charAt(left++)]++ >= 0) {
				cnt++;
			}
		}
		return result;

	}

}
