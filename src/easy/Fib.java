package easy;

public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(2*n)
	public static int fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static int fib(int n, int[] memo) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (memo[n] == 0) {
			memo[n] = fib(n - 1) + fib(n - 2);
		}
		return memo[n];
	}

	// Dynamic Programming
	public static int fib1(int n) {
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

}
