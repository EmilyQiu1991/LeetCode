package easy;

public class UniquePaths1 {

	public static void main(String[] args) {

	}

	public static int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		int[][] grid = new int[m][n];
		for (int i = 0; i <n; i++) {
			grid[0][i] = 1;
		}R
		for (int i = 0; i <m; i++) {
			grid[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}
		return grid[m-1][n-1];
	}
	//optimazed to havae O(min(m,n)) space complexity
	public static int uniquePaths(int m, int n) {
		int[] dp= new int[m];
	}
	
	public static int uniquePaths2(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		if (m == 1 || n == 1) {
			return 1;
		} else {
			return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
		}
	}

}
