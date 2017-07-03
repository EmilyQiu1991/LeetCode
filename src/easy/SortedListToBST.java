package easy;

import java.util.LinkedList;

public class SortedListToBST {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		sortedListToBST(head);
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		TreeNode node = toBST(head, null);
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			System.out.println(currentNode.val);
			queue.add(currentNode.left);
			queue.add(currentNode.right);
		}
		return node;
	}

	public static TreeNode toBST(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == tail)
			return null;

		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;// fast speed is twice of slow, fast is at the
									// end of the list,slow is at the middle of
									// list
			slow = slow.next;
			System.out.printf("fast:%d;slow:%d\n", fast == null ? null : fast.val, slow.val);
		}
		TreeNode thead = new TreeNode(slow.val);
		thead.left = toBST(head, slow);
		thead.right = toBST(slow.next, tail);
		return thead;
	}

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}
		public static void print(ListNode head){
			while(head!=null){
				System.out.print(head.val+"->");
				head=head.next;
			}
		}
	}


}
