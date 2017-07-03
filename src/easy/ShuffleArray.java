package easy;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
	int[] nums;
	Random random = new Random();

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		ShuffleArray shuffle = new ShuffleArray(a);
		shuffle.shuffle2();

	}

	public ShuffleArray(int[] nums) {
		this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (nums == null)
			return null;
		int[] a = nums.clone();
		// The assumption here is, we are given a function rand() that generates
		// random number in O(1) time.
		// The idea is to start from the last element, swap it with a randomly
		// selected element from
		// the whole array (including last).
		// Now consider the array from 0 to n-2 (size reduced by 1), and repeat
		// the process till we hit the first element.
		for (int j = 1; j < a.length; j++) {
			int i = random.nextInt(j + 1);
			swap(a, i, j);
			System.out.println(Arrays.toString(a));
		}
		return a;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public int[] shuffle2() {
		if (nums == null)
			return null;
		int[] a = nums.clone();

		for (int i = a.length - 1; i >= 1; i--) {
			int j = random.nextInt(i);
			swap(a, i, j);
			System.out.println(Arrays.toString(a));
		}
		return a;
	}

}
