/**
 * EpicSystem letsDoItOnceAgain keypadPermutation.java
 * 
 */
package letsDoItOnceAgain;

import java.util.*;

/**
 * @author milesyang
 * @date Jul 9, 2015 12:32:10 PM
 */
public class keypadPermutation {

	public static void main(String args[]) {
		String input = "23";
		print(input);
	}

	public static void print(String input) {
		List<String> res = new ArrayList<String>();
		generate(input.length(), 0, "", res, input);
		System.out.println(res);
	}

	public static void generate(int right, int left, String pre,
			List<String> res, String in) {

		String[] keyPad = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS",
				"TUV", "WXYZ" };

		if (right == 0) {
			res.add(pre);
			return;
		}
		String c = keyPad[in.charAt(left) - '0'];
		for (int i = 0; i < c.length(); i++) {
			generate(right - 1, left + 1, pre + c.charAt(i), res, in);
		}
	}
}
