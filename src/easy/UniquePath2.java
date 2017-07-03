package easy;

import java.util.Arrays;

public class UniquePath2 {

	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		grid[1][1] = 1;
		System.out.println(uniquePathsWithObstacles(grid));

	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0)
			return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;

		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else if (i == 0 && j == 0) {
					obstacleGrid[i][j] = 1;
				} else if (i == 0) {
					obstacleGrid[i][j] = obstacleGrid[i][j - 1];
				} else if (j == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				} else {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				}
			}
		}
		System.out.println(Arrays.toString(obstacleGrid));
		return obstacleGrid[m - 1][n - 1];
	}

	// other's solution
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}

}
