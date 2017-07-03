package hard;

import easy.TreeNode;

public class LargestBST {
	Integer last_node = null;
	 int maxSize = Integer.MIN_VALUE;
	TreeNode res = null;
	public static void main(String[] args) {
		int[] preOrder = {10,5,1,8,15,7};
		int[] inOrder = {1,5,8,10,15,7};
		TreeNode tree = TreeNode.buildTree(inOrder, preOrder, 0, 5);
		LargestBST l = new LargestBST();
		System.out.println("$$$"+l.largestBSTSubtree(tree));
	}
	
	//write a method here to calculate the size of tree if it is bst
	//if it is not ,return -1
	public int isBST(TreeNode node){
		if(node == null) return 0;
		//check left subtree
		int leftSize = isBST(node.left);
		//if left subtree is not bst , return -1 directly, no need to check right subtree
		if(leftSize==-1){
			return -1;
		}
		if(leftSize >maxSize){
			maxSize = leftSize;
			res = node.left;
		}
		//left subtree is BST, compare last node with root node, 
		if(last_node!=null&&node.val<=last_node){
			return -1;
		}
		last_node = node.val;
		//continue check right subtree
		int rightSize = isBST(node.right);
		if(rightSize ==-1){
			return -1;
		}
		if(rightSize>maxSize){
			maxSize = rightSize;
			res = node.right;
		}
		return leftSize+1+rightSize;
	}
	public int largestBSTSubtree(TreeNode root) {
		last_node1 = null;
        if(isValidBST(root)){
        	System.out.println(count(root)+" is valid tree");
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
    }
    Integer last_node1 =null;
    
    public boolean isValidBST(TreeNode root) {
      
      if(root==null) return true;
      if(!isValidBST(root.left)) return false;//go straight to the leftmost leaf
      if(last_node1!=null&&root.val<=last_node1) return false;
      else last_node1=root.val;//assign the leftmost leaf to last _node
      if(!isValidBST(root.right)) return false;
      return true;
    }
       
    public int count(TreeNode root){
        if(root==null) return 0;
        return 1+count(root.left)+count(root.right);
    }

}
