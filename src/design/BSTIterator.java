package design;
import java.util.*;
import easy.TreeNode;

public class BSTIterator {
	ArrayList<Integer> list ;
	int index=0;//always point to next element to return
    public BSTIterator(TreeNode root) {
	        list =  new ArrayList<Integer>();
	        inorderTraversal(root,list);
	 }

	 private void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
	     if(root==null) return;
		 inorderTraversal(root.left,list);
		 list.add(root.val);
		 inorderTraversal(root.right,list);
		
	 }
		/** @return whether we have a next smallest number */
	 public boolean hasNext() {
	        return list.size()!=0&&index!=list.size();
	 }

	    /** @return the next smallest number */
	 public int next() {
	     if(!hasNext()){
	         throw new EmptyStackException();
	     }
	     int res = list.get(index);
	     index++;
	     return res;
	 }

}
