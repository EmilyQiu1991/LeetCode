package combinations;
import java.util.*;
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		p.permute(new int[]{1,2,3});
	}
	 public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 backtrack(list,new ArrayList<Integer>(),nums);
		 return list;
	 }
	 private void backtrack(List<List<Integer>> list, List<Integer> tempList,int[] nums){
		 if(tempList.size()==nums.length){
			 list.add(new ArrayList<>(tempList)); //add deep copy of tempList to list
			 for(int i:tempList){
				 System.out.print(i);
			 }
			 System.out.println();
		 }else{
			 for(int i=0;i<nums.length;i++){
				 if(tempList.contains(nums[i])){
					 continue;
				 }
				 tempList.add(nums[i]);
				 backtrack(list,tempList,nums);
				 //to generate all possible permutations, we need to remove the least recently added
				 //element while we are going to the recursive call stack
				 tempList.remove(tempList.size()-1);
				 //In the first iteration of the for loop , we add all permutaions, that start with nums[0]
			 }
		 }
		 
	 }

}
