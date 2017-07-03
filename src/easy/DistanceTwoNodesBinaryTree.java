package easy;

public class DistanceTwoNodesBinaryTree {

	public static void main(String[] args) {

	}

	public static int getDistance(TreeNode root,TreeNode first,TreeNode second){
		if(first.val<)
	}

	public static int parentToChild(TreeNode parent, TreeNode child) {
		if (parent == child)
			return 0;
		else if (parent.left == null)
			return -1;
		int left = parentToChild(parent.left, child);
		int right = parentToChild(parent.right, child);

		return left == -1 ? ++right : ++left;
	}

}
