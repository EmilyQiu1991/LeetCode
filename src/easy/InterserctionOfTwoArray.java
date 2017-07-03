package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterserctionOfTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set1 = new HashSet<Integer>();
		for (int i : nums1) {
			set.add(i);
		}
		for (int i : nums2) {
			if (set.contains(i)) {
				set1.add(i);
			}
		}
		int[] arr = new int[set1.size()];
		int i = 0;
		for (int val : set1) {
			arr[i++] = val;
		}
		return arr;
	}

	public int[] intersectionSorted(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> set = new HashSet<Integer>();
		int i = 0, j = 0; // 2 pointers for nums1 and nums2
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;
			} else {
				j++;
			}
		}
		int index = 0;
		int[] arr = new int[set.size()];
		for (int val : set) {
			arr[index++] = val;
		}
		return arr;
	}

	// Each element in the result should appear as many times as it shows in
	// both arrays.
	public int[] intersection2(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int val : nums1) {
			if (map1.containsKey(val)) {
				map1.put(val, map1.get(val) + 1);
			} else {
				map1.put(val, 1);
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int val : nums2) {
			if (map1.containsKey(val) && map1.get(val) > 0) {
				result.add(val);
				map1.put(val, map1.get(val) - 1);
			}
		}
		int[] arr = new int[result.size()];
		int index = 0;
		for (int val : result) {
			arr[index++] = val;
		}
		return arr;
	}

}
