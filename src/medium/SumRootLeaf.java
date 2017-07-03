package medium;

import easy.TreeNode;
import java.util.*;
public class SumRootLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		List<Integer> list  = new ArrayList<Integer>();
		dfs(list,0,root);
		for(int i:list){
			sum+=i;
		}
		return sum;
    }
	public void dfs(List<Integer> list, int temp, TreeNode root){
		if(root==null) return;
		if(root.left==null&&root.right==null){
			list.add(temp);
		}else{
			if(root.left!=null)
			dfs(list,temp*10+root.val,root.left);
		    
			if(root.right!=null)
			dfs(list,temp*10+root.val,root.right);	
		}
	}
	
}
