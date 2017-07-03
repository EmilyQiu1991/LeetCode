package microSoftOA;
import java.util.*;
public class LongestConsecutiveSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestConsecutive(int[] nums) {
    	Set<Integer> set = new HashSet<Integer>();
    	int max = 0;
    	for(int num:nums){
    		set.add(num);
    	}
    	for(int num: nums){
    		int length = 1;
    		//explore left side sequence
    		int down = num-1;
    		while(set.contains(down)){
    			set.remove(down);
    			length++;
    			down--;
    		}
    		int up = num+1;
    		while(set.contains(up)){
    			set.remove(up);
    			length++;
    			up++;
    		}
    		max = Math.max(max, length);
    		
    	}
    	return max;
    }

}
