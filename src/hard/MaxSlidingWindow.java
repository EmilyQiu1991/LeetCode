package hard;
import java.util.*;
public class MaxSlidingWindow {


	
	public static void main(String[] args) {
		int[] arr = {1,3,-1,-3,5,3,6,7};
		MaxSlidingWindow m = new MaxSlidingWindow();
		m.maxSlidingWindow(arr, 3);
	}
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0||k==0) return nums;
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<nums.length;i++){
        	if(!deque.isEmpty()&& i-deque.getFirst()==k){
        		deque.removeFirst();
        	}
        	while(!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
        		deque.removeLast();
        	}
        	deque.addLast(i);
        	if(i>=k-1){
        		res[index]=nums[deque.getFirst()];
        		index++;
        	}
        	
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

}
