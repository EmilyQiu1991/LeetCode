package amazonQA;

public class BSTDistance1 {
	public class BTreeNode {
		BTreeNode left;
		BTreeNode right;
		int val;

		public BTreeNode(BTreeNode left, int val, BTreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		BSTDistance1 b = new BSTDistance1();
		int values[] = { 5, 6, 3, 1, 2, 4 };
		// testing getDistanceForBST

		System.out.println(b.bstDistance(values, 6, 1, 4));
	}

	public int bstDistance(int[] values, int n, int node1, int node2) {
		if (values == null || values.length == 0) {
			return -1;
		}
		BTreeNode b = new BTreeNode(null, values[0], null);
		for (int i = 1; i < n; i++) {
			insert(b, values[i]);
		}
		int rootToNode1 = getDistanceForBST(b, node1);
		int rootToNode2 = getDistanceForBST(b, node2);
		if (rootToNode1 == -1 || rootToNode2 == -1) {
			return -1;
		}
		BTreeNode lca = getLCAInBST(b, node1, node2);
		int rootToLca = getDistanceForBST(b, lca.val);
		return rootToNode1 + rootToNode2 - rootToLca * 2;
	}
	public void insert(BTreeNode node, int num) {
		BTreeNode newNode = new BTreeNode(null, num, null);
		if (num > node.val) {
			if (node.right == null) {
				node.right = newNode;
			} else {
				insert(node.right, num);
			}
		} else {
			if (node.left == null) {
				node.left = newNode;
			} else {
				insert(node.left, num);
			}
		}
	}
	public BTreeNode getLCAInBST(BTreeNode root, int node1, int node2) {
		if (root == null) {
			return null;
		}
		while ((root.val - node1) * (root.val - node2) > 0) {
			root = node1 < root.val ? root.left : root.right;
		}
		return root;
	}

	public int getDistanceForBST(BTreeNode root, int node) {
		int distance = 0;
		while (root != null && root.val != node) {
			root = node < root.val ? root.left : root.right;
			distance++;
		}
		return root == null ? -1 : distance;
	}

	// this method if node1 does not in root, return -1
	public int getDistance(BTreeNode root, int node1) {
		if (root == null) {
			return -1;
		}
		if (root.val == node1) {
			return 0;
		}
		int left = getDistance(root.left, node1);
		int right = getDistance(root.right, node1);
		if (left != -1) {
			return left + 1;
		}
		if (right != -1) {
			return right + 1;
		}
		return -1;
	}

	// assume two nodes both in this tree, this method is for general binaryTree
	public BTreeNode getLCA(BTreeNode root, int node1, int node2) {
		// remember to check root == null
		if (root == null || root.val == node1 || root.val == node2) {
			return root;
		}
		BTreeNode left = getLCA(root.left, node1, node2);
		BTreeNode right = getLCA(root.right, node1, node2);
		if (left != null && right != null)
			return root;
		return left == null ? right : left;
	}

}
