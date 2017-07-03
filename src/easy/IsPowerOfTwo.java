package easy;

public class IsPowerOfTwo {

	public static void main(String[] args) {

	}

	public boolean isPowerOfTwo(int n) {
		while (n > 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				return false;
			}
		}
		return n == 1;
	}

	// Power of 2 means only one bit of n is '1'
	// use the trick n&(n-1)==0 to judge whether this is the case
	public boolean isPowerOfTwoBit(int n) {
		if (n <= 0)
			return false;
		if ((n & (n - 1)) == 0) {
			return true;
		} else {
			return false;
		}
	}

}
