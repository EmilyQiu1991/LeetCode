package microSoftOA;

import java.util.*;

public class MaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumSubArray m = new MaxSumSubArray();
		System.out.println(Arrays.toString(m.maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4})));
	}
	//return max sum, start index, end index
	public int[] maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        int start = 0;
        int end = 0;
        for(int i=1;i<nums.length;i++){        
            dp[i]= Math.max(dp[i-1]+nums[i],nums[i]);
        	if(dp[i]>max){
        		end = i;
        		max = dp[i];
        		//check whether need to update start, if before numbers will make it smaller
        		if(dp[i-1]<0){
        			start = i;
        		}
        	}
        }
        return new int[]{max,start,end};
    }
    public int firstUniqChar(String s) {
        // Write your code here
        HashMap<Character,Integer> map  = new HashMap<Character,Integer>();
        for(int i=0;i<s.toCharArray().length;i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.toCharArray().length;i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

}
