package easy;

import ListNode;

public class IntersectionTwoLinkedLists {
	ListNode head;

	public static void main(String[] args) {
		ListNode head = null;
		append(head, 1);
		ListNode head1 = new ListNode(1);
		append(head1, 2);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {// traversal
																			// LinkedList
																			// must
																			// note
																			// that
																			// use
																			// a
																			// variable
																			// to
																			// track
		// don't use headA, headB, this will destory the original ListNode
		ListNode result = new ListNode(0);
		ListNode currentA = headA;
		while (currentA != null) {
			int val = currentA.val;

			if (contains(headB, val)) {
				append(result, val);
			}
			currentA = currentA.next;
		}
		return result.next;
	}

	public boolean contains(ListNode head, int val) {
		if (head == null)
			return false;
		ListNode current = head;
		while (current != null) {
			if (current.val == val) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void append(ListNode head, int data) {
		if (head == null) {
			head = new ListNode(data);
			return;
		}
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new ListNode(data);
	}

}
