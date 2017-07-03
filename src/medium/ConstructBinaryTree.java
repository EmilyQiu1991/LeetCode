package medium;

import easy.TreeNode;

public class ConstructBinaryTree {

	public static void main(String[] args) {
		ConstructBinaryTree c = new ConstructBinaryTree();
		c.buildTree(new int[]{2,1,3}, new int[]{2,3,1});
	}
	private  int rootIndex = 0;
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if(inorder.length==0||postorder.length==0||postorder.length!=inorder.length) return null;
	        rootIndex = postorder.length-1;
	        return helper(inorder,postorder,0,inorder.length-1);
	    }
		public TreeNode helper(int[] inorder,int[] postorder, int start,int end){
		    if(start>end){
		        return null;
		    }
	        TreeNode root = new TreeNode(postorder[rootIndex]);
	        rootIndex--;
	        //assume it is valid
	        int index = search(inorder,root.val,start,end);
	        root.right = helper(inorder,postorder,index+1,end);
	        root.left= helper(inorder,postorder,start,index-1);
	        return root;
		}
		public int search(int[] inorder,int target, int start, int end){
		    for(int i=start;i<=end;i++){
		        if(inorder[i]==target){
		            return i;
		        }
		    }
		    return -1;
		}

}
