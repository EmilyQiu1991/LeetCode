package algorithm;

import java.util.Arrays;

/**
 * @author qiuyu
 * This class implements Quick Sort algorithm
 * quick sort has O(nlogn) average, Worst case O(N^2)  
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {7,7,9,8,6,6,8,7,9,8,6,6};
		char[] chars={'a','b','A','c','D'};
		sortLetters(chars);
		quickSort(nums,0,nums.length-1);
		System.out.println(Arrays.toString(nums));
	//System.out.println(findKthLargest(nums,0,1,2));
	}
	public static void quickSort(int[] nums, int left, int right){
		if(left>=right) return;	
		//get partition devider point index
		int index = partition(nums,left,right);
		quickSort(nums,left,index-1);
		quickSort(nums,index,right);
	}
	
	/**
	 * this is the key process of quicksort, 
	 * make all elements smaller than pivot comes before all element greater than pivot
	 * given an array and 
	 * @param nums
	 * @param left
	 * @param right
	 * @return index of the partition divider point
	 */
	public static int partition(int[] nums,int left,int right){
		int pivot=nums[(left+right)/2];
		//make left right toward each other
		while(left<=right){
			//find element greater than pivot
			while(nums[left]<pivot) left++;
			while(nums[right]>pivot) right--;
			if(left<=right){
				swap(nums,left,right);
				left++;
				right--;
			}
			System.out.println("Left Index:"+left+"  Right Index:"+right);
			System.out.println(Arrays.toString(nums));
		}
		return left;
	}
	private static void swap(int[] nums, int left, int right) {
		int temp= nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
		
	}
	public static int findKthLargest(int[] nums,int left, int right,int k){
		int pivot=nums[(left+right)/2];
		//get partition devider point index
		int index = partition(nums,left,right);
		if((right-index+1)==nums.length-k){
			return pivot;
		}
		else if(index > nums.length-k){
			return findKthLargest(nums,left,index,k);
		}else{
			return findKthLargest(nums,index+1,right,k);
		}
		
	}
	/**
	 * @param nums
	 * @param k maybe is not an element of nums, so left and right could be outofIndexBound
	 * @return
	 */
	public static int partitionArray(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
	    //write your code here
	    int left =0,right=nums.length-1;
	    while(left<right){
	        while(left<=nums.length-1&&nums[left]<k) left++;
	        while(nums[right]>=k) right--;
	        if(left<right){
	            swap(nums,left,right);
	            left++;
	            right--;
	        }
	    }
	    return left-1;
    }
	/**xx
	 * the idea is similar to tail, the point is not removing ,instead, we swap the numbers greater than k
	 * numbers smaller than k
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int partitionArray2(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
	    int tail=0;
	    for(int i=0;i<nums.length;i++){
	    	if(nums[i]<k) {
	    		swap(nums,tail,i);
	    		tail++;
	    		}
	    }
	    return tail;
    }
	public static void sortLetters(char[] chars) {
        //write your code here
        int tail=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='a'&&chars[i]<='z'){//remember this, determine whether a letter is lowercase,( 'A'=65,'a'=97)
                swap(chars,tail,i);
                tail++;
            }
        }
    }
    private static void swap(char[] nums, int left, int right) {
		char temp= nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
		
	}

}
