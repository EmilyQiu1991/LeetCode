package easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
	public int findKthLargest(int[] nums, int k) {//O(NlogN)
		Arrays.sort(nums);
		//note not return nums[k-1], 1st largest is nums.length-1, 2nd largets is nums.length-1
		//kth largest is nums.length-k
		return nums[nums.length-k];//this is O(1) operation
	}
	public int findKthLargest2(int[] nums, int k) {//O(NlogK)
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		for(int i:nums){
			pq.offer(i);
			if(pq.size()>k){
				pq.poll();
			}
		}
		return pq.peek();
	}
	//quick select 则平均复杂度为O(N)，最坏复杂度为O(N^2)
	public static int findKthLargest3(int []nums,int k){
		return quickSelect(nums,0,nums.length-1,nums.length-k+1);
	}
	public static int quickSelect(int[] nums,int start, int end,int k){
		int pivot = nums[end];//set the end element to pivot
		//compare pivot , partition array
		int tail=start;
		for(int i=start;i<end;i++){
			if(nums[i]<=pivot){
				//nums[tail++]=nums[i]; 这一定要小心，不是remove，而是move元素，所以是swap,
				swap(nums,tail,i);
				tail++;
			}
		}//after this for loop. element <=pivot are at left side,the number of elements is left, then 
		swap(nums,tail,end);
		//count how many numbers <= pivot
		int count = tail-start+1;
		if(count==k){
			//then pivot is the kth smallest element
			return pivot;
		}else if(count<k){
			//search in right side
			return quickSelect(nums,tail+1,end,k-count);
		}else{
			return quickSelect(nums,start,tail-1,k);
		}	
	}
	private static void swap(int[] nums,int left, int right){
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}

}
