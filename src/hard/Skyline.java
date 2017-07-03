package hard;
import java.util.*;
public class Skyline {

	public static void main(String[] args) {
		int[][] arr = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		getSkyline(arr);
	}
	 public static List<int[]> getSkyline(int[][] buildings) {
	      List<int[]> height = new ArrayList<int[]>();
	      List<int[]> res = new ArrayList<int[]>();
	      for(int[] b:buildings){
	    	  //left top is negative height
	    	  height.add(new int[]{b[0],-b[2]});
	    	  height.add(new int[]{b[1],b[2]});
	      }
	     Collections.sort(height,(a,b)->a[0]-b[0]); 
	     //construct max heap
	     Queue<Integer> queue  = new PriorityQueue<Integer>(height.size(),(a,b)->b-a);
	     queue.offer(0);//add horizon to queue
	     int pre = 0; //keep track of height last time added to res
	     for(int[] h : height){
	    	 if(h[1]<0){
	    		 queue.offer(-h[1]);
	    	 }else{
	    		 queue.remove(h[1]);
	    	 }
	    	 int cur = queue.peek();
	    	 if(cur!=pre){
	    		 res.add(new int[]{h[0],cur});
	    		 pre = cur;
	    	 }
	     }
	     return res;
	 }
	

}
