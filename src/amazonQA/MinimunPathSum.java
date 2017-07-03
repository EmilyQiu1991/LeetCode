package amazonQA;
import java.util.*;
public class MinimunPathSum {
	private class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode() {
		}
	}

	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void mini(TreeNode root, int sum) {
		if (root.left == null && root.right == null) {
			res = Math.min(sum + root.val, res);
			return;
		}
		if (root.left != null)
			mini(root.left, sum + root.val);
		if (root.right != null)
			mini(root.right, sum + root.val);
	}

	public static int minPath4(TreeNode root) {
          if (root == null) {
￼				return 0; 
          }
          if (root.left == null && root.right == null) {
               return root.val;
          }
          int minSum = Integer.MAX_VALUE;
          Stack<TreeNode> pathNode = new Stack<TreeNode>();
          Stack<Integer> pathSum = new Stack<Integer>();
          pathNode.push(root);
          pathSum.push(root.val);
          while (!pathNode.isEmpty()) {
               TreeNode curNode = pathNode.pop();
               int curSum = pathSum.pop();
               if (curNode.left == null && curNode.right == null) {
                     if (curSum < minSum) {
                          minSum = curSum;
                     } else {
                          minSum = minSum;
                     }
               }
               if (curNode.right != null) {
                     pathNode.push(curNode.right);
                     pathSum.push(curSum + curNode.right.val);
               }
               if (curNode.left != null) {
                     pathNode.push(curNode.left);
                     pathSum.push(curSum + curNode.left.val);
               }
}
          return minSum;
    }

	//
	public static int minPath2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right == null) {
			return minPath2(root.left) + root.val;
		}
		if (root.left == null && root.right != null) {
			return minPath2(root.right) + root.val;
		}
		return Math.min(minPath2(root.left), minPath2(root.right)) + root.val;
	}

	//
	public static int minPath1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		if (root.left == null) {
			return root.val + minPath1(root.right);
		}
		if (root.right == null) {
			return root.val + minPath1(root.left);
		}
		return root.val + Math.min(minPath1(root.left), minPath1(root.right));
	}

}
