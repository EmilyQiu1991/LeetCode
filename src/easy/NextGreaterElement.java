package easy;

import java.util.*;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] findNums={4,1,2};
		int[] nums={1,3,4,2};
		nextGreaterElement(findNums,nums);
	}
	
	 public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		 
	         int[] res = new int[findNums.length];
	         for(int i=0;i<res.length;i++){
	            res[i]=-1;
	        }
	         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	         Stack<Integer> stack = new Stack<Integer>();
	         for(int i =0;i<nums.length;i++){
	             if(stack.isEmpty()){
	                 stack.push(nums[i]);
	                 continue;
	             }
	             while(!stack.isEmpty()&&nums[i]>stack.peek()){
	                 map.put(stack.pop(),nums[i]);
	             }
	             stack.push(nums[i]);
	         }
	         for(int i=0;i<res.length;i++){
	            res[i]= (map.containsKey(findNums[i])?map.get(findNums[i]):-1);
	         }
	         return res;
	     
	    
	    }

}
