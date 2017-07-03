package combinations;
import java.util.*;
public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c = new Combinations();
		c.combine(4, 2);
	}
	 public List<List<Integer>> combine(int n, int k) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 
	      backtrack(n,list,new ArrayList<Integer>(),k,1);
	      return list;
	 }
	 public void backtrack(int n,List<List<Integer>> list, List<Integer> tempList, int k,int start){
		 if(tempList.size()==k){
			list.add(new ArrayList<Integer>(tempList));
			for(int i:tempList){
				 System.out.print(i);
			 }
			System.out.println();
		 } else{
			 for(int i=start;i<=n;i++){ 
				 tempList.add(i);
				 backtrack(n,list,tempList,k,i+1);
				 tempList.remove(tempList.size()-1);
			 }
		 }
	 }

}
