package medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums= {10,9,2,5,3,7,101};
		lengthOfLIS2(nums);
	}
	public int lengthOfLIS(int[] nums) {
		 if(nums.length==0) return 0 ;//the corner case ,I forget it
		 //represents the longest non-decreasing sequence which has its last number nums[i]
        int[] dp=new int[nums.length];
        int lis=1;
        for(int i=0;i<nums.length;i++){
        	dp[i]=1;
        	for(int j=0;j<i;j++){
        		if(nums[j]<nums[i]){
        			dp[i]=Math.max(dp[j]+1, dp[i]);
        			lis=Math.max(lis, dp[i]);
        		}
        	}
        }
        return lis;
    }
	//so hard to understand
	//this is the author's explanation
	/*The basic idea is present in the majority of solutions shared for this task, 
	 * I have only tried to implement it in a manner as concise as possible without damaging the code readability.
	The idea is that as you iterate the sequence, you keep track of the minimum value a subsequence of given length might end with, 
	for all so far possible subsequence lengths.So dp[i] is the minimum value a subsequence of length i+1 might end with. 
	Having this info, for each new number we iterate to, we can determine the longest subsequence 
	where it can be appended using binary search.
 	The final answer is the length of the longest subsequence we found so far.*/
	public static int lengthOfLIS2(int[] nums) {
		 int[] dp = new int[nums.length];
	        int len = 0;

	        for(int x : nums) {
	            int i = Arrays.binarySearch(dp, 0, len, x);
	            if(i < 0) i = -(i + 1);
	            dp[i] = x;
	            if(i == len) len++;
	        }

	        return len;
	}

}
