package recursiveAndDynamicProgramming;
import java.util.*;
public class DecodingWays {
	public int numDecodings(String s) {
	      if(s==null||s.length()==0){
	    	  return 0;
	      }
	      int n = s.length();
	      int[] f = new int[n+1];
	      f[0] = 1;
	      f[1] = s.charAt(0)!='0'?1:0;
	      for(int i=2;i<s.length();i++){
	    	  if(s.charAt(i-1)!='0'){
	    		  f[i] = f[i-1];
	    	  }
	    	  int twoDigits = (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
	    	  if(twoDigits>=10&&twoDigits<=26){
	    		  f[i]+=f[i-2];
	    	  }
	      }
	      return f[s.length()];
    }
    public int findPeakElement(int[] nums) {
        
        int start = 0, end = nums.length-1;
        while(start<end){
            int mid = start +(end-start)/2;//mid 1
            if(mid==0||mid==nums.length-1) return mid;
            if(nums[mid+1]<nums[mid]&&nums[mid-1]>nums[mid]){
                return mid;
            }else if(nums[mid+1]<nums[mid]){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        return start;
        
    }
    public int findMinArrowShots(int[][] points) {
        //sort points based on start point
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int[] pre = points[0];
        int count=0;
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=pre[1]){
            	pre[1]=Math.min(points[i][1], pre[1]);
            }else{
                //if this points can not merge to pre, then increase count by 1, pre need a arrow
            	count++;
            	pre = points[i];
            }
        }
        return count+1;
    }
    public static void main(String args[]){
    	int[][] point = {{10,16},{2,8},{1,6},{7,12}};
    	DecodingWays d = new DecodingWays();
    	d.findMinArrowShots(point);
    }
    	
}
