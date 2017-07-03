package medium;

import easy.TreeNode;

public class LargestBSTSubtree {
	TreeNode last_node = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int largestBSTSubtree(TreeNode root) {
		 
	}
	public int helper(TreeNode root){
		if(root==null) return 0;
		helper(root.left);
		
	}

}
