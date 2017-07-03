package easy;

import java.util.Arrays;

public class ReshapeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = { { 1, 2, 3, 4 } };
		System.out.print(Arrays.toString(matrixReshape(nums, 2, 2)));
	}

	// my solution O(nm)
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums.length == 0)
			return nums;
		int numsCols = nums[0].length;
		if (r * c == nums.length * nums[0].length) {
			// reshape nums
			int[][] newMatrix = new int[r][c];
			int index = 0;
			int numsRowIndex = 0;
			int numsColIndex = 0;
			// populating new matrix
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < r; j++) {
					index = i * c + j;
					numsRowIndex = index / numsCols;
					numsColIndex = index % numsCols;// this should devide by
													// numsCols, not numsRows
					newMatrix[i][j] = nums[numsRowIndex][numsColIndex];
				}
			}
			return newMatrix;
		} else {
			return nums;
		}
	}

	// other's solution
	public int[][] matrixReshape2(int[][] nums, int r, int c) {
		int n = nums.length, m = nums[0].length;
		if (r * c != n * m)
			return nums;
		int[][] res = new int[r][c];
		for (int i = 0; i < r * c; i++)
			res[i / c][i % c] = nums[i / m][i % m];// We can use matrix[index /
													// width][index % width] for
													// both the input and the
													// output matrix.
		return res;
	}
}
