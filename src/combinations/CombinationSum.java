package combinations;
import java.util.*;
public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		c.combinationSum(new int[]{2,3,6,7},7);
	}
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        backtrack(candidates,list,new ArrayList<Integer>(),target,0);
	        return list;
	}
	 public void backtrack(int[] nums,List<List<Integer>> list, List<Integer> tempList, int remaining,int start){
		 if(remaining == 0){
			list.add(new ArrayList<Integer>(tempList));
			for(int i:tempList){
				 System.out.print(i);
			 }
			System.out.println();
		 } else if(remaining >0 ){
			 for(int i=start;i<nums.length;i++){
				 if(nums[i]>remaining){
					 continue;
				 }
				 tempList.add(nums[i]);
				 backtrack(nums,list,tempList,remaining-nums[i],i);
				 tempList.remove(tempList.size()-1);
				 
			 }
		 }
	 }
	 
	

}
