package microSoftOA;

import easy.TreeNode;

public class ClosestBSTValue {

	public static void main(String[] args) {
		int[] inorder = {1,2,3,4,5,6,7};
		int[] preorder = {4,2,1,3,6,5,7};
		TreeNode tree = TreeNode.buildTree(inorder, preorder, 0, 6);
		System.out.println(getSecondBSTValue(tree,0));
	}
	public int getClosestBSTValue(TreeNode root,int k){
		if(root==null) return 0;
		int res = root.val;
		while(root!=null){
			if(Math.abs(root.val-k)<Math.abs(res-k)){
				res = root.val;
			}
			if(k>root.val){
				root= root.right;
			}else if(k==root.val){
				return root.val;
			}else{
				root=root.left;
			}
		}
		return res;
	}
	public static int getSecondBSTValue(TreeNode root,int k){
		Integer res = Integer.MAX_VALUE;
		while(root!=null){
			if(root.val>k){
				if(root.val<res){
					res = root.val;
				}
				root=root.left;
			}
			else if(root.val <= k){
				root= root.right;
			}
			
		}
		return res==Integer.MAX_VALUE?-1:res;
	}

}
