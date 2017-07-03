package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz2(5));

	}

	public static List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i <= n; i++) { // start i from 1, not zero, in this
										// case, don't need to plus 1 later, and
										// consider 0%3=1 0%5=0 that is stupid
			// first consider i is multiples of both 3 and 5
			// then else i is multiples only 3,
			// then else i is multiples only 5,

			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0)
				result.add("Fizz");
			else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i));// take this method would be
												// better than i+""
			}

		}
		return result;
	}

	// Not using "%" operation
	public static List<String> fizzBuzz2(int n) {
		List<String> result = new ArrayList<String>();
		for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
			fizz++;
			buzz++;
			if (fizz == 3 && buzz == 5) {
				result.add("FizzBuzz");
				fizz = 0;
				buzz = 0;
			} else if (fizz == 3) {
				result.add("Fizz");
				fizz = 0;
			} else if (buzz == 5) {
				result.add("Buzz");
				buzz = 0;
			} else {
				result.add(String.valueOf(i));
			}
		}
		return result;
	}

}
