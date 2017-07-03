package easy;
import java.util.*;
public class FindDisappearedNumbers {

	public static void main(String[] args) {
		int[] arr = {3,4,-1,1};
		firstMissingPositive(arr);

	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n  = nums.length;
        for(int i=0;i<nums.length;i++){
            int val = (nums[i]-1)%n-1;
            System.out.println(val+ "  "+i);
            nums[val]=nums[val]+n;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<n){
                res.add(i);
            }
        }
        return res;
    }
	 public static int firstMissingPositive(int[] nums) {
	        if(nums==null||nums.length==0) return 1;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]>0&&nums[i]-1<nums.length&&nums[nums[i]-1]!=nums[i]){
	            	swap(nums,nums[i]-1,i);
	            	i--;
	            }
	        }
	        System.out.println(Arrays.toString(nums));
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]!=i+1)
	            return i+1;
	        }
	        return nums[nums.length-1]+1;
	    }
	    public static void swap(int[] nums,int a,int b){
	        int temp=nums[a];
	        nums[a]=nums[b];
	        nums[b]=temp;
	    }
}
