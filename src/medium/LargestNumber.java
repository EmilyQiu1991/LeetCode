package medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		String s1= "924";
		String s2 = "249";
	}
	 public String largestNumber(int[] nums) {
	     String[] strs = new String[nums.length];
	     //convert to string arr so we can use self defined sort later 
	     for(int i=0;i<nums.length;i++){
	    	 strs[i]=String.valueOf(nums[i]);
	     }
	     Comparator<String> c = new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);//reverse order here ,descending order
				//so we can append directly later
			}
	     };
	     Arrays.sort(strs,c);
	     StringBuilder sb  = new StringBuilder();
	     for(String s : strs){
	    	 sb.append(s);
	     }
	     //An edge case by lc, say you have only a bunch of zeros, the result will be 00000
	     if(sb.charAt(0)=='0'){
	    	 return "0";
	     }
	     return sb.toString();
	      
	 }

}
