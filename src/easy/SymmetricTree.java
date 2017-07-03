package easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	public static void main(String[] args) {

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	// recursive
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		// the following three conditions must be true
		// 1- their root node's key must be same
		// 2- left subtree of left tree and right subtree of right have to be
		// symmetric
		// 3- right subtree of left tree and left subtree of right have to be
		// symmetric
		if (left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left))
			return true;
		else
			return false;

	}

	// non -recursive
	public boolean isSymmetric1(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root.left);
		queue.add(root.right);
		while (!queue.isEmpty()) {
			TreeNode p = queue.remove();
			TreeNode q = queue.remove();
			if (p == null && q == null)
				continue;
			if (p == null || q == null)
				return false;
			if (p.val != q.val)
				return false;
			queue.add(p.left);
			queue.add(q.right);
			queue.add(p.right);
			queue.add(q.left);
		}
		return true;
	}

}
