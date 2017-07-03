package easy;

public class BuildTreePreAndIn {
	static int preIndex = 0;

	public static void main(String[] args) {
		int[] inorder = { 1, 2 };
		int[] preorder = { 2, 1 };
		BuildTreePreAndIn build = new BuildTreePreAndIn();
		build.buildTree(inorder, preorder);

	}

	public TreeNode buildTree(int[] inorder, int[] preorder) {
		return buildTree(inorder, preorder, 0, inorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int[] preorder, int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(preorder[preIndex++]);
		if (inStart == inEnd)
			return node;
		int nodeIndex = search(inorder, node.val, inStart, inEnd);
		node.left = buildTree(inorder, preorder, inStart, nodeIndex - 1);
		node.right = buildTree(inorder, preorder, nodeIndex + 1, inEnd);
		return node;

	}

	public int search(int[] inorder, int value, int inStart, int inEnd) {
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == value) {
				return i;
			}
		}
		return -1;

	}

}
