package hard;

import java.util.*;

import easy.TreeNode;
public class PostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode head = new TreeNode(1);
		head.right=new TreeNode(2);
		preorderTraversal(head);
	}
	public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left==null&&node.right==null){
                res.add(stack.pop().val);
            }else if(node.right!=null){
                stack.push(node.right);
                node.right=null;
            }
            if(node.left!=null){
                stack.push(node.left);
                node.left=null;
            }
        }
        return res;
    }
	public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty()&&root!=null){
        	while(root!=null){
        		stack.push(root);
        		root=root.left;
        	}
        	TreeNode node = stack.pop();
        	res.add(node.val);
        	root= node.right;
        }
        return res;
    }
	public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        while(!stack.isEmpty()||root!=null){
        	while(root!=null){
        		stack.push(root);
        		res.add(root.val);
        		root=root.left;
        	}
        	TreeNode node = stack.pop();
        	root= node.right;
        }
        return res;
    }
	

}
