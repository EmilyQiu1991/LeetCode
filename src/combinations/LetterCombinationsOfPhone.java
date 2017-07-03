package combinations;

import java.util.*;

public class LetterCombinationsOfPhone {
	String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
			return list;
		dfs(list, "", digits);
		return list;
	}

	public void dfs(List<String> list, String prefix, String digits) {
		if (digits.length() == 0) {
			list.add(prefix);
			return;
		}
		int index = digits.charAt(0) - '0';// char '2' =50 or can use
									// Character.getNumericValue
		for (int i = 0; i < map[index].length(); i++) {
			dfs(list, prefix + map[index].charAt(i), digits.substring(1, digits.length()));
		}
	}
	

}
