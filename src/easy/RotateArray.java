package easy;

import java.util.Arrays;

import easy.SortedListToBST.ListNode;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
	    rotate(nums,1);
	    System.out.println(Arrays.toString(nums));
	}
	
	public static void rotate(int[] nums, int k) {
	        k = k%nums.length;
	        reverse(nums,0,k-1);
	        reverse(nums,k,nums.length-1);
	        reverse(nums,0,nums.length-1);
	}
	public static void reverse(int[] nums,int start, int end){
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
	public ListNode rotateRight(ListNode head, int k) {
	    ListNode cur= head;
	    int length=0;
	    while(cur!=null){
	    	length++;
	    	cur=cur.next;
	    }
	    cur = head;
	    int step = 0;
	    while(step<length-k){
	    	cur = cur.next;
	    }
	    ListNode newHead = cur.next;
	    cur.next=null;
	    newHead.next=head;
	    return newHead;
	}

}
