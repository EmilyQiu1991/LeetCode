package combinations;
import java.util.*;
public class PermutationsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3};
		
		PermutationsOfString a=new PermutationsOfString();
		//a.permutation("123");
		a.combine(4,2);
	}
	void permutation(String str){
		permutation("",str);
	}
	void permutation(String prefix,String str){
		if(str.length()==0){
			System.out.println(prefix);
		}else{
			for(int i=0;i<str.length();i++){
				String rem=str.substring(0, i)+str.substring(i+1);
				permutation(prefix+str.charAt(i),rem);
			}
		}
	}
	public void permute(int[] nums) {
		  // List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(new ArrayList<>(),nums);
		  // return list;
		}
	
		/**
		 * @param list result
		 * @param tempList contains already generated String , perfix 
		 * @param nums available numbers can be used to generate the combination
		 */
		private void backtrack(List<Integer> prefix, int [] nums){
		   if(prefix.size() == nums.length){
		     System.out.println(prefix.toString());//templist is complete ,add to result;
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(prefix.contains(nums[i])) continue; // element already exists, skip
		         prefix.add(nums[i]);
		         backtrack(prefix, nums);
		         prefix.remove(prefix.size() - 1);
		      }
		   }
		}
		
		public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> res= new ArrayList<List<Integer>>();
	        backtracking(res,new ArrayList<Integer>(),n,k,1);
	        return res;
	        
	    }
	    public void backtracking(List<List<Integer>> res,List<Integer> prefix,int n, int k,int start)
	    {
	        if(prefix.size()==k){
	            res.add(prefix);
	        }else{
	            for(int i=start;i<=n;i++){
	                prefix.add(i);
	                backtracking(res,prefix,n,k,start+1);
	                prefix.remove(prefix.size()-1);
	            }
	        }
	    }
}
