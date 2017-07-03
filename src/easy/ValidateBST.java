package easy;

import medium.SeriAndDeserBST;

public class ValidateBST {
	Integer last_printed=null;
	static int count=0;
	static TreeNode tree= SeriAndDeserBST.deserialize("8,3,1,6,4,7,10,14,13");
	public static void main(String[] args) {
		System.out.println(count(tree));

	}
	boolean checkBST(TreeNode n){
		if(n==null) return true;
		
		//check/recurse left
		if(!checkBST(n.left)) return false;
		
		//check current
		if(last_printed!=null&&n.val<=last_printed){
			return false;
		}
		last_printed=n.val;
		
		//check /recurse right
		if(!checkBST(n.right)) return false;
		return true;//all good
	}
	public static int count(TreeNode root){
		if(root==null) return 0;
		int leftCount=count(root.left);
		int rightCount = count(root.right);		
		return leftCount+1+rightCount;
	}
	public static int kthSmaller(TreeNode root,int k){
		if( root==null) return -1;
		int leftCount=count(root.left);
		if(leftCount>=k) kthSmaller(root.left,k);
		int rightCount=count(root.left);
		if(rightCount<k) kthSmaller(root.right,k-leftCount-1);
		return root.val;
	}
	

}
