package combinations;
import java.util.*;
public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum2 c = new CombinationSum2();
		
		c.combinationSum2(new int[]{1, 6, 1},8);
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		  List<List<Integer>> list = new ArrayList<List<Integer>>();
		  Arrays.sort(candidates);
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
				 //note here is i>start 
				 if(nums[i]>remaining|| (i>start && nums[i]==nums[i-1])){
					 continue;
				 }
				 tempList.add(nums[i]);
				 backtrack(nums,list,tempList,remaining-nums[i],i+1);
				 tempList.remove(tempList.size()-1);
			 }
		 }
	 }

}
