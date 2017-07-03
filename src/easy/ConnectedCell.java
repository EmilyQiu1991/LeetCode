package easy;

public class ConnectedCell {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };
		System.out.println(getBiggestRegion(grid));
	}

	public static int getBiggestRegion(int[][] matrix) {
		int maxRegion = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 1) {
					int size = getRegionSize(matrix, row, col);
					maxRegion = Math.max(size, maxRegion);
				}
			}
		}
		return maxRegion;
	}

	public static int getRegionSize(int[][] matrix, int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
			return 0;
		if (matrix[row][col] == 0)
			return 0;
		int size = 1;
		matrix[row][col] = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (c != row || r != col)
					size += getRegionSize(matrix, r, c);
			}
		}
		return size;
	}

}
