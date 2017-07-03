package easy;

public class KClosestPoints {

	public static void main(String[] args) {
		int arr[] = { 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int n = arr.length;
		int x = 35, k = 4;

		KClosestPoints searchCrossover = new KClosestPoints();

		int index = searchCrossover.findCrossOver(arr, 0, arr.length - 1, 3);
		searchCrossover.printKClosestPoint(arr, 35, 4);
	}

	// return the index of crossover point
	public int binarySearchCrossoverPoint(int[] arr, int low, int high, int x) {
		if (arr[high] <= x)
			return high;
		if (arr[low] > x)
			return low;

		int mid = (low + high) / 2;// mid point
		if (arr[mid] == x)
			return mid;
		else if (arr[mid] > x) {
			return binarySearchCrossoverPoint(arr, low, mid - 1, x);
		} else {
			return binarySearchCrossoverPoint(arr, mid + 1, high, x);
		}
	}

	int findCrossOver(int arr[], int low, int high, int x) {
		// Base cases
		if (arr[high] <= x) // x is greater than all
			return high;
		if (arr[low] > x) // x is smaller than all
			return low;

		// Find the middle point
		int mid = (low + high) / 2; /* low + (high - low)/2 */

		/* If x is same as middle element, then return mid */
		if (arr[mid] <= x && arr[mid + 1] > x)
			return mid;

		/*
		 * If x is greater than arr[mid], then either arr[mid + 1] is ceiling of
		 * x or ceiling lies in arr[mid+1...high]
		 */
		if (arr[mid] < x)
			return findCrossOver(arr, mid + 1, high, x);

		return findCrossOver(arr, low, mid - 1, x);
	}

	public void printKClosestPoint(int[] arr, int x, int k) {
		int l = binarySearchCrossoverPoint(arr, 0, arr.length - 1, x);
		int r = l + 1;
		int count = 0;// To keep track of count of elements already printed
		// If x is present in arr[],then reduce left index
		// Assumption : all elements in arr[] are distinct
		if (arr[l] == x)
			l--;

		while (l >= 0 && r < arr.length && count < k) {
			if (x - arr[l] < arr[r] - x) {
				System.out.println(arr[l--]);
			} else {
				System.out.println(arr[r++]);
			}
			count++;
		}
		//
		while (count < k && l >= 0) {
			System.out.println(arr[l--]);
			count++;
		}
		while (count < k && r < arr.length) {
			System.out.println(arr[r++]);
			count++;
		}

	}

}
