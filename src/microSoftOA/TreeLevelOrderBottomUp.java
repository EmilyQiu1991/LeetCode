package microSoftOA;
import java.util.*;
import easy.TreeNode;

public class TreeLevelOrderBottomUp {

	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		TreeLevelOrderBottomUp t = new TreeLevelOrderBottomUp();
		TreeNode tree = TreeNode.buildTree(in, pre, 0, 6);
		t.reversePrint(tree);
		
	}
	 //use queue and stack
     public void reversePrint(TreeNode root)
     {
    	 Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	 Stack<Integer> stack = new Stack<Integer>();
    	 queue.offer(root);
    	 while(!queue.isEmpty()){
    		 int size = queue.size();
    		 for(int i=0;i<size;i++){
    			 TreeNode node = queue.poll();
    			 System.out.print(node.val);
    			 stack.push(node.val);
    			 //Note: put right node firstly and then left
    			 //so we can print in order in stack
    			 if(node.right!=null){
    				 queue.offer(node.right);
    			 }
    			 if(node.left!=null){
    				 queue.offer(node.left);
    			 }
    		 }
    	 }
    	 while(!stack.isEmpty()){
    		 System.out.println(stack.pop());
    	 }
     }
     //recursive method
     public void printGivenOrder(TreeNode root, int level){
    	 if(root==null){
    		 return;
    	 }
    	 if(level==1){
    		 System.out.println(root.val);
    	 }else{
    		 printGivenOrder(root.left,level-1);
    		 printGivenOrder(root.right,level-1);
    	 }
     }

}
