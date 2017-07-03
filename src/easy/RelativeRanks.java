package easy;
import java.util.*;
public class RelativeRanks {

	public static void main(String[] args) {
		  BitSet bits1 = new BitSet(16);
	      BitSet bits2 = new BitSet(16);
	      
	      // set some bits
	      for(int i = 0; i < 16; i++) {
	         if((i % 2) == 0) bits1.set(i);
	         if((i % 5) != 0) bits2.set(i);
	      }
	     
	      System.out.println("Initial pattern in bits1: ");
	      System.out.println(bits1);
	      System.out.println("\nInitial pattern in bits2: ");
	      System.out.println(bits2);

	      // AND bits
	      bits2.and(bits1);
	      System.out.println("\nbits2 AND bits1: ");
	      System.out.println(bits2);

	      // OR bits
	      bits2.or(bits1);
	      System.out.println("\nbits2 OR bits1: ");
	      System.out.println(bits2);

	      // XOR bits
	      bits2.xor(bits1);
	      System.out.println("\nbits2 XOR bits1: ");
	      System.out.println(bits2);
}
	
	 public String[] findRelativeRanks(int[] nums) {
	        int[][] pair = new int[nums.length][2];
	        for (int i = 0; i < nums.length; i++) {
	            pair[i][0] = nums[i];
	            pair[i][1] = i;
	        }
	        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
	  
	        String[] result = new String[nums.length];

	        for (int i = 0; i < nums.length; i++) {
	            if (i == 0) {
	                result[pair[i][1]] = "Gold Medal";
	            }
	            else if (i == 1) {
	                result[pair[i][1]] = "Silver Medal";
	            }
	            else if (i == 2) {
	                result[pair[i][1]] = "Bronze Medal";
	            }
	            else {
	                result[pair[i][1]] = (i + 1) + "";
	            }
	        }

	        return result;
	    }

}
