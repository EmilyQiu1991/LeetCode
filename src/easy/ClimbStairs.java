package easy;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int climbStairs(int n) {
		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i <= 2)
				arr[i] = i;
			else
				arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}

	public int climbStairs2(int n) {
		if (n <= 2)
			return n;
		int preOne = 1;
		int preTwo = 2;
		for (int i = 3; i <= n; i++) {
			int total = preOne + preTwo;
			preOne = preTwo;
			preTwo = total;
		}
		return preTwo;
	}
	public int countWays(int n,int[] memo){
		if()
	}

}
