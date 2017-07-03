package easy;

import java.util.ArrayList;

public class TreeNode {
	static int preIndex = 0;
	private static int rootIndex = 0;
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	// arr is the preorder traversal result
	public TreeNode(int[] arr) {
		// construct a balanced tree with given array

	}

	public ArrayList<Integer> preorder(TreeNode node) {
		if (node == null)
			return null;
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(node.val);
		results.addAll(preorder(node.left));
		results.addAll(preorder(node.right));
		return results;
	}

	public static TreeNode buildTree(int in[], int pre[], int inStrt, int inEnd) {
		if (inStrt > inEnd)
			return null;
		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		TreeNode tNode = new TreeNode(pre[preIndex++]);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return tNode;

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search(in, inStrt, inEnd, tNode.val);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
		return tNode;
	}

	private static int search(int[] arr, int inStrt, int inEnd, int val2) {
		int i;
		for (i = inStrt; i <= inEnd; i++) {
			if (arr[i] == val2)
				return i;
		}
		return i;
	}

	public static void main(String args[]) {
		int[] inorder = { 1,2 };
		int[] preorder = {2,1};
		TreeNode.buildTree1(inorder, preorder);

	}
	public static TreeNode buildTree1(int[] inorder, int[] preorder) {
        if(inorder.length==0||preorder.length==0||preorder.length!=inorder.length) return null;
       return helper(inorder,preorder,0,inorder.length-1);
    }
	public static TreeNode helper(int[] inorder,int[] preorder, int start,int end){
	    if(start>end){
	        return null;
	    }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        //assume it is valid
        int index = search1(inorder,preorder[rootIndex],start,end);
        if(start <= index-1)
        {
            rootIndex++;
            root.left = helper(inorder,preorder,start,index-1);
        }
        if(index+1 <= end){
            rootIndex++;
            root.right= helper(inorder,preorder,index+1,end);
        }
        return root;
	}
	public static int search1(int[] inorder,int target, int start, int end){
	    for(int i=start;i<=end;i++){
	        if(inorder[i]==target){
	            return i;
	        }
	    }
	    return -1;
	}
}
