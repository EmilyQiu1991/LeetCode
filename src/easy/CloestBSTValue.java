package easy;

public class CloestBSTValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findNearestInBST(double target, TreeNode root){
		if(root==null) return -1;
		int res=root.val;
		while(root!=null){
			if(Math.abs(target-root.val)<res){
				res=(int) Math.abs(target-root.val);
			}
			root=target<root.val?root.left:root.right;
		}
		return res;
	}

}
