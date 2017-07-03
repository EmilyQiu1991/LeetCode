package easy;

import java.util.Arrays;

public class ArrayPartition1 {

	public static void main(String[] args) {
		ArrayPartition1 arrPar = new ArrayPartition1();
		int[] input = { 1, 4, 3, 2 };
		System.out.print(arrPar.arrayPairSum(input));

	}

	// my own method, this is a nlogn solution
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);// faster sort algorithm is nlogn,merge
							// sort(nlogn),quick sort,bucket sort
		int n = nums.length / 2;
		int minOfPair = 0;
		int maxSum = 0;
		// this is linear
		for (int i = 0; i < n; i++) {
			minOfPair = Math.min(nums[2 * i], nums[2 * i + 1]);
			maxSum += minOfPair;
		}
		return maxSum;
	}

	// other's solution, the sum of 1st, 3rd, 5th... will be the result, make
	// sense
	public int arrayPairSum2(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}

}
