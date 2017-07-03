package easy;

public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// my solution
	public int hammingDistance(int x, int y) {
		int z = x ^ y;// only the corresponding bits are different, the result
						// corresponding bit will be 1
		int result = 0;
		for (int i = 0; i < 32; i++) {
			if ((z & (1 << i)) != 0)// if(z&(1<<i) is not equal 0, the ith bit
									// of z is 1 , which indicates the
									// corresponding bits of x and // y are
									// different
				result++;
		}
		return result;
	}

	// others solution
	// What does come to your mind first when you see this sentence
	// "corresponding bits are different"? Yes, XOR!
	// Also, do not forget there is a decent function Java provided:
	// Integer.bitCount()
	public int hammingDistance2(int x, int y) {
		return Integer.bitCount(x ^ y);
	}

}
