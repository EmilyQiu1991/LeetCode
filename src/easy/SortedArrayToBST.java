package easy;

import java.util.Arrays;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, arr.length)));

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int size = nums.length;
		TreeNode node = new TreeNode(nums[size / 2]);
		if (size >= 2)
			node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, size / 2));
		if (size >= 3)
			node.right = sortedArrayToBST(Arrays.copyOfRange(nums, size / 2 + 1, size));
		return node;
	}

}
