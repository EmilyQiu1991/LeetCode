package medium;
import java.util.*;
public class MaximumXOR {

	public static void main(String[] args) {
		int[] nums={3, 10, 5, 25, 2, 8};
		MaximumXOR m = new MaximumXOR();
		m.findMaximumXOR(nums);
		
	}
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
        	String s = "ss";
        	
        	System.out.println(Integer.toBinaryString(1<<i));
            mask = mask | (1 << i);//get prefix of nums in nums
            System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            for(int k:set){
            	System.out.print(k+"  ");
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
