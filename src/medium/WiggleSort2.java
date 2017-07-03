package medium;

import java.util.Arrays;

public class WiggleSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1, 5, 1, 1, 6, 4};
		WiggleSort2 w = new WiggleSort2();
		w.wiggleSort(arr);
	}
	public void wiggleSort(int[] nums){
	    int[] copy  = nums.clone();
	    Arrays.sort(copy);
	    int mid = (copy.length-1)/2;
	    int end = copy.length-1;
	    for(int i=0;i<nums.length;i++){
	    	//i is odd(i&1==i), need to be smaller, get from first half of copy
	    	//i is even(i&i), need to be bigger, get from second half of copy  
	    	nums[i] = (i%2)==0?copy[mid--]:copy[end--];
	    }
	    System.out.println(Arrays.toString(nums));
	}
	public void swap(int[] nums, int i, int j){
	        int temp  = nums[i];
	        nums[i]=nums[j];
	        nums[j]=temp;
	}

}
