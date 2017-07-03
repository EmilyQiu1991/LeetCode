package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBinaryTree {

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 3 };
		int[] preorder = { 1, 2, 4, 5, 3 };
		TreeNode node = TreeNode.buildTree(inorder, preorder, 0, inorder.length - 1);
		LevelOrderBinaryTree t = new LevelOrderBinaryTree();
		t.levelOrder2(node);
	}

	public int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int height = getHeight(root);
		for (int i = 1; i <= height; i++) {
			result.add(printGivenLevel(root, i));
		}
		return result;
	}

	private List<Integer> printGivenLevel(TreeNode root, int level) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		if (level == 1) {
			result.add(root.val);
			return result;
		} else if (level > 1) {
			result.addAll(printGivenLevel(root.left, level - 1));
			result.addAll(printGivenLevel(root.right, level - 1));
		}
		return result;

	}

	List<List<Integer>> printLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int h = getHeight(root);
		int i;
		for (i = 1; i <= h; i++)
			result.add(printGivenLevel2(root, i));
		return result;
	}

	List<Integer> printGivenLevel2(TreeNode root, int level) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		if (level == 1) {
			result.add(root.val);
			return result;
		} else if (level > 1) {
			result.addAll(printGivenLevel2(root.left, level - 1));
			result.addAll(printGivenLevel2(root.right, level - 1));
		}
		return result;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if (root == null)
			return wrapList;

		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}

}
