package medium;

import easy.TreeNode;
import java.util.*;

public class SeriAndDeserBST {
	private static final String SEP=",";
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
        serializeHelp(root,sb);
        return sb.toString();
    }
    public static void main(String args[]){
    	int[] preOrder={5,3,2,6,7};
    	int[] inorder={2,3,5,6,7};
    	TreeNode tree=TreeNode.buildTree(inorder, preOrder, 0, 4);
    	SeriAndDeserBST a= new SeriAndDeserBST();
    	String s=a.serialize(tree);
    	a.deserialize(s);
    }

    /**
     * @param root
     * @param sb recusive
     */
    private void serializeHelp(TreeNode root, StringBuilder sb) {
    	if(root==null) return;
    	sb.append(root.val).append(SEP);
    	serializeHelp(root.left,sb);
    	serializeHelp(root.right,sb);
	}
   
  
    

	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    Queue<Integer> queue= new LinkedList<Integer>();
    String[] nodes= data.split(SEP);
    for(String node:nodes){
    	queue.offer(Integer.valueOf(node));
    }
       return deserializeHelp(queue);
    }

	public static TreeNode deserializeHelp(Queue<Integer> queue) {
		if(queue.isEmpty()) return null;
		TreeNode root= new TreeNode(queue.poll());
		Queue<Integer> queueForLeftSubTree= new LinkedList<Integer>();
		while(!queue.isEmpty()&&queue.peek()<root.val){	
			queueForLeftSubTree.offer(queue.poll());	
		}
		root.left=deserializeHelp(queueForLeftSubTree);
		root.right=deserializeHelp(queue);
		return root;
	}
    
}
