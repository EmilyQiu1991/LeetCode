package combinations;
import java.util.*;
public class Subsets2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets2 s = new Subsets2();
		s.subsetsWithDup(new int[]{1,2,2});
	}
	 public List<List<Integer>> subsetsWithDup(int[] nums) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		  Arrays.sort(nums);
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
			 //1,2,2, push first 2 to recursive stack, no need to push second 2 to push stack, will
			 //cause duplicates subsets
			 if(i>start && nums[i]==nums[i-1]){
				 continue;
			 }
			 tempList.add(nums[i]);
			 backtrack(nums,list,tempList,i+1);
			 tempList.remove(tempList.size()-1);
		 }
		
	 }
	 

}
