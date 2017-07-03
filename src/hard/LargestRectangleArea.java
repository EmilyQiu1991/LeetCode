package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// A utility function to find minimum of 3 integers
	private int max(int x, int y, int z) {
		return Math.max(Math.max(x, y), z);
	}

	// A utility function to get minimum of 2 numbers in hist[]
	private int minVal(int[] hist, int i, int j) {
		if (i == -1)
			return j;
		if (j == -1)
			return i;
		return (hist[i] < hist[j] ? i : j);
	}

	// A utility function to get the middle index from corner indexs
	private int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	public int getMaxArea(int hist[], int n) {
		int[] st = constructST(hist, n);
		return getMaxAreaRec(hist, st, n, 0, n - 1);
	}

	// A recursive function to find the maximum rectangular area
	// It uses segment tree 'st' to find the minimum value in hist[l..r]
	private int getMaxAreaRec(int[] hist, int[] st, int n, int l, int r) {
		//base cases
		if(l>r) return Integer.MIN_VALUE;
		if(l==r) return hist[l];
		//Find index of the minimum value in given range
		//This take O(Logn) time
		int m
		return 0;
	}

	private int[] constructST(int[] hist, int n) {
		// Allocate memeory for segment tree
		int x = (int) Math.ceil(Math.log(n) / Math.log(2));// height of segment
															// tree
		int max_size = 2 * (int) Math.pow(2, x) - 1;// max size of segment tree
		int[] st = new int[max_size];
		contructSTUtil(hist, 0, n - 1, st, 0);

		return st;
	}

	// A recursive function that constructs Segment Tree for hist[ss...se]
	// si is index of current node in segment tree st
	private int contructSTUtil(int[] hist, int ss, int se, int[] st, int si) {
		// If there is only 1 element in between ss and se, store it in current
		// node of
		// of segment tree and return
		if (ss == se)
			return (st[si] = ss);

		// If there are more than one elments, the recur for left and right
		// subtree and stor
		// the minimum of 2 values in this node
		int mid = getMid(ss, se);
		st[si] = minVal(hist, contructSTUtil(hist, ss, mid, st, si * 2 + 1),
				contructSTUtil(hist, mid + 1, se, st, si * 2 + 2));
		return st[si];

	}

	private public int largestRectangleArea(int[] heights) {
		int largestArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int count = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] >= heights[i])
					count++;
				else
					break;
			}
			for (int j = i + 1; j < heights.length; j++) {
				if (heights[j] >= heights[i])
					count++;
				else
					break;
			}
			int area = heights[i] * count;
			largestArea = Math.max(largestArea, area);
		}
		return largestArea;
	}

	public int getMaxArea2(int hist[], int n) {
		// store the index of bar in hist array
		Stack<Integer> s = new Stack<Integer>();
		int max_area = 0;
		int tp;// to store top of stack
		int area_with_top; // to store area with top bar as the samllest bar
		// run through all bars of given histogram
		int i = 0;
		while (i < n) {
			// If this bar is higher than the bar on the top stack, putsh it to
			// stack
			if (s.empty() || hist[s.peek()] <= hist[i]) {
				s.push(i++);
			}
			// If this bar is lower than top of stack, than calculate area of
			// rectangle with stack top as the smallest (or minimum height) bar
			else {
				tp = s.pop();// store the top index and pop top index
				area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
				if (max_area < area_with_top)
					max_area = area_with_top;

			}

		}
		while (!s.empty()) {
			tp = s.peek();
			area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
			if (max_area < area_with_top)
				max_area = area_with_top;
		}
		return max_area;
	}

}
