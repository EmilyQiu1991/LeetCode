package medium;
import java.util.*;
import easy.TreeNode;

public class InorderSuccessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur.val!=p.val){
        	stack.push(cur);
        	if(cur.val>p.val){
        		cur = cur.left;
        	}else{
        		cur = cur.right;
        	}
        }
        //condtion 1 : P has right child, the result is the leftmost child of its right child
        if(cur.right!= null){
        	cur = cur.right;
        	while(cur.left!=null){
        		cur= cur.left;
        	}
        	return cur;
        }else{
        //condition 2 : p doesn't have right child, left children are all smaller than p, 
        	//so , search from root node to target root path
        	while(!stack.isEmpty()&&stack.peek().val<cur.val){
        		stack.pop();
        	}
        	return stack.isEmpty()?null:stack.pop();
        }
        
    }

}
