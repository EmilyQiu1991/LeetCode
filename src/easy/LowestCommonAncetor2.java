package easy;

import java.util.List;

import amazonQA.ClosetCommonManager.Employee;

public class LowestCommonAncetor2 {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root == p || root == q)
			return root;
		// look for keys in left and right subtrees
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		// the node which has one key present in its left subtree and the other
		// key present in right subtree is the LCA
		// if both keys lie in left subtree,then left subtree has LCA also,
		// otherwise LCA lies in right subtree
		// if both of the above calls return NOn-null,then one key is present in
		// once subtree and other is present in other
		// so the node is the LCA
		if (left != null && right != null)
			return root;
		// otherwise check if left subtree or right subtree is LCA
		return left != null ? left : right;
	}
	static class Employee {
		final String name;
		List<Employee> reporters;

		public Employee(final String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee{" + "name='" + name + '\'' + '}';
		}
	}
	public Employee closestCommonManager(Employee ceo, Employee p, Employee q){
		if(ceo == null||ceo == p ||ceo==q){
			return ceo;
		}
		
		for(Employee e : ceo.reporters){
			
		}
	}

}
