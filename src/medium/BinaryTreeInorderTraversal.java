package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import easy.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder={1,2,3,4,5};
		int[] preorder={4,2,1,3,5};
		System.out.println(inorderTraversal(TreeNode.buildTree(inorder, preorder, 0, 4)));
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = root;

	    while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        list.add(cur.val);
	        cur = cur.right;
	    }

	    return list;
	}

}
