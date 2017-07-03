package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinaryTree {

	public static void main(String[] args) {
		int[] inorder = { 2, 1, 3 };
		int[] preorder = { 1, 2, 3 };
		TreeNode treenode = TreeNode.buildTree(inorder, preorder, 0, 2);
		minDepth(treenode);
	}

	// BFS
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 1;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode current;
			int levelCount = queue.size();// must store current node count
											// firstly,this is the point, must
											// remember
			for (int i = 0; i < levelCount; i++) {// Correct :for(int i =
													// 0;i<queue.size();i++),queue
													// size changes when offer
													// node to queue in for loop
				current = queue.poll();
				if (current.left == null && current.right == null) {
					return level;
				}
				if (current.left != null) {
					queue.offer(current.left);
				}
				if (current.right != null) {
					queue.offer(current.right);
				}
			}
			level++;

		}
		return level;
	}

	// The idea is to traverse the given Binary Tree.
	// For every node, check if it is a leaf node. If yes, then return 1. If not
	// leaf node then if left subtree is NULL,
	// then recur for right subtree. And if right subtree is NULL,
	// then recur for left subtree. If both left and right subtrees are not
	// NULL,
	// then take the minimum of two heights.
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

	}

}
