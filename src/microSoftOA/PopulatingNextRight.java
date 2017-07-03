package microSoftOA;

public class PopulatingNextRight {
	 public class TreeLinkNode {
		      int val;
		     TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void connect(TreeLinkNode root) {
		 if(root==null) return;
		 if(root.left!=null) {
			 root.left.next=root.right;
		 }
		 if(root.right!=null){
			 if(root.next!=null){
				 root.right.next=root.next.left;
			 }else{
				 root.right.next=null;
			 }
		 }
		 connect(root.left);
		 connect(root.right);
		 
	 }
	 public void connect1(TreeLinkNode root) {
		 if(root==null) return;
		 if(root.left!=null) {
			 if(root.right!=null)root.left.next=root.right;
			 else{
				 if(root.next!=null){
				   root.left.next= (root.next.left==null)?root.next.right:root.next.left;
				 }
			 } 
		 }
		 if(root.right!=null){
			 if(root.next!=null){
				   root.right.next= (root.next.left==null)?root.next.right:root.next.left;
			  }
		 }
		 connect(root.left);
		 connect(root.right);
		 
	 }

}
