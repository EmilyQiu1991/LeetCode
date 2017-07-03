package easy;

public class NumberComplement {

	public static void main(String[] args) {
		System.out.println(findComplement(5));

	}

	public static int findComplement(int num) {
		int mask = (Integer.highestOneBit(num) << 1) - 1;
		num = ~num;
		return num & mask;// 1 & (~n)=~n
	}

	// can't understand why this works
	public int findComplement2(int num) {
		int mask = Integer.highestOneBit(num) - 1;
		num = ~num;
		return mask & num;
	}
}
