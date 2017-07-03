package easy;

public class LowestCommonAncetor {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// suppose p and q are children of root
		if (root == null)
			return null;
		if (p.val < root.val) {
			if (q.val >= root.val) {
				return root;
			} else {
				return lowestCommonAncestor(root.left, p, q);
			}
		} else if (p.val == root.val)
			return root;
		else {
			if (q.val <= root.val) {
				return root;
			} else {
				return lowestCommonAncestor(root.right, p, q);
			}
		}
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)// their values are
															// both smaller or
															// both larger than
															// root's
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	// suppose node is binary search tree
	public static boolean contains(TreeNode node, TreeNode p) {
		if (node.val == p.val) {
			return true;// It is there
		} else if (p.val < node.val) {
			if (node.left == null)
				return false;
			else {
				return contains(node.left, p);
			}
		} else {
			if (node.right == null)
				return false;
			else {
				return contains(node.right, p);
			}
		}
	}
}
