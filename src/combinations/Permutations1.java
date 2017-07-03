package combinations;
import java.util.*;
public class Permutations1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations1 p = new Permutations1();
		p.permuteUnique(new int[]{1,2,2,2});
		
	}
	 public List<List<Integer>> permuteUnique(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        backtrack(nums,list,new ArrayList<Integer>(), new boolean[nums.length]);
	        return list;
	    }
	public void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tempList, boolean[] used){
		if(tempList.size()==nums.length){
			list.add(new ArrayList<Integer>(tempList));
			for(int i:tempList){
				 System.out.print(i);
			 }
			System.out.println();
		}else{
			for(int i=0;i<nums.length;i++){
				if(used[i]||(i>0 && nums[i]==nums[i-1] && used[i-1])){
					continue;
				}
				tempList.add(nums[i]);
				used[i] = true;
				backtrack(nums,list,tempList,used);
				
				//reset variable
				used[i]=false;
				tempList.remove(tempList.size()-1);
			}
		}
	}

}
