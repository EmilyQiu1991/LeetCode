package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		int[] inorder = { 2, 4, 1, 3 };
		int[] preorder = { 1, 2, 4, 3 };
		TreeNode node = TreeNode.buildTree(inorder, preorder, 0, inorder.length - 1);
		BinaryTreeRightSideView r = new BinaryTreeRightSideView();
		r.rightSideView2(node);

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		List<List<Integer>> levelOrderTraversal = leveOrder(root);
		for (List<Integer> levelNodes : levelOrderTraversal) {
			result.add(levelNodes.get(levelNodes.size() - 1));
		}
		return result;
	}

	public List<List<Integer>> leveOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelNode = new ArrayList<Integer>();
			for (int i = 1; i <= levelSize; i++) {
				TreeNode node = queue.peek();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				levelNode.add(node.val);
				queue.poll();
			}
			result.add(levelNode);
		}
		return result;
	}

	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}
		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);
	}

}
