package easy;

import easy.SortedListToBST.ListNode;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums = {1};
		removeDuplicatesFromSortedArrayII(nums);
	}
	public static int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int firstPoint = 0,secondPoint = 1;
        int duplicate= 0;
        while(secondPoint+duplicate<nums.length){
            if(nums[firstPoint]==nums[secondPoint]){
                duplicate++;
                int temp=nums[secondPoint];
                for(int i=secondPoint+1;i<nums.length;i++){
               // while(secondPoint+1<nums.length){
                    nums[i-1]=nums[i];
                    //secondPoint++;
                    
                }//move nums[secondpoint+1...n-1] forward
                nums[nums.length-1]=temp;//put duplicate to the end of nums
            }else{
                firstPoint++;
                secondPoint++;
            }
        }
        return nums.length-duplicate;
    }
	//other's solution
	/**similar with remove element from array,
	 * the difference is how to determine whether element put the new fake array
	 * the first element must put into new fake array, tail start with 1,
	 * @param A
	 * @param n
	 * @return
	 */
	public static int removeDuplicates(int[] A,int n){
		if(n<2) return n;
		int index=1;
		for(int i =1;i<n;i++){
			if(A[i]!=A[i-1]) A[index++]=A[i];
		}
		return index;
	}
	public ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        while(current!=null&&current.next!=null){
            //If the next node is the same with current,delete that node,until next node is different
            while(current.next!=null&&current.next.val==current.val){
                current.next=current.next.next;
            }
            //finish last while, the current.next should be the different node
            current=current.next;
        }
        return head;
    }
	/**
	 * @param nums
	 *the idea is image there is a new array you can use to copy eligible elements to it, 
	 *tail is the pointer of the fake array, initiate it to Zero, 
	 *walk through the elment , if the element not equal val, copy that element to nums[tail]
	 *increament tail by one to make it point to next place
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums,int val){
		 int tail=0;//the fake pointer of new array
			for(int i=0;i<nums.length;i++){
				if(nums[i]!=val){
				    nums[tail++]=nums[i];
				} 
				
			}
			return tail;
	}

	/**duplicates are allowed at most twice
	 * For example, given {1,1,1,2,2,3} return {1,1,2,2,3}
	 * tail start from 2, because nums[0],nums[1] must be in fake new array
	 * compare nums[i] with nums[i-1] , if different, then nums[i] could put nums[tail], tail +1
	 * if the same, ok, compare with nums[i-1] ,if different ok, it 's fine, allow twice, also put nums[tail],
	 * if the same, already have 2 such element in fake new array, skip ,move to next elmemt
	 * @param nums
	 * @return
	 */
	public static int removeDuplicatesFromSortedArrayII(int[] nums) {
		int tail=2;
		for(int i=2;i<nums.length;i++){
			if(nums[i]!=nums[tail-1]||nums[i]!=nums[tail-2]){//compare with elments in tail seems like more understandble
				nums[tail]=nums[i];
				tail++;
			}
		}
		return tail;
	}

}
