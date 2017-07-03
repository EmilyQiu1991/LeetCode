package microSoftOA;

import java.util.BitSet;

public class BloomFilterInt {

	public static void main(String[] args) {
		BloomFilterInt b = new BloomFilterInt();
		BitSet bits = new BitSet((int)Math.pow(2, 32));
		int[] nums = {0,1,2,3,4,5,7,8,9,10,11};
		System.out.println( b.missingInt(nums));
	}
	public int missingInt(int[] nums){
		long numberOfInts = (long)Integer.MAX_VALUE+1;
		byte[] bitfield = new byte[(int)(numberOfInts/8)];
		for(int num:nums){
			//set the bit at position num to 1
			bitfield[num/8] |=1<< (num%8);
		}
		for(int i =0; i<bitfield.length;i++){
			for(int j=0;j<8;i++){
				if((bitfield[i]&(1<<j))==0){
					return i*8+j; 
				}
			}
		}
		return -1;
	}

}
