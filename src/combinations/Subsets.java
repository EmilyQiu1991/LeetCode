package combinations;
import java.util.*;
public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets s = new Subsets();
		s.subsets(new int[]{1,2,3});
	}
	 public List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
	      backtrack(nums,list,new ArrayList<Integer>(),0);
	      return list;
	 }
	 public void backtrack(int[] nums, List<List<Integer>> list,List<Integer> tempList,int start){
		for(int i:tempList){
			 System.out.print(i);
		}
		System.out.println();
	    list.add(new ArrayList<Integer>(tempList));
	    for(int i= start;i<nums.length;i++){
		  tempList.add(nums[i]);
		  backtrack(nums,list,tempList,i+1);
		  tempList.remove(tempList.size()-1);
	    }
	 }
	 

}
