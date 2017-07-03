package amazonQA;

import easy.SortedListToBST.ListNode;

public class ReverseSecondHalfList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		//head.next.next.next.next.next = new ListNode(6);
		ReverseSecondHalfList r = new ReverseSecondHalfList();
		ListNode newNode = r.reverseSecondHalfList(head);
		ListNode.print(newNode);
	}
	//if mid is in the middle , start from mid, if not ,start from mid+1
	public ListNode reverseSecondHalfList(ListNode head){
		if(head == null ||head.next==null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		//1->2->3->4->5->6
		while(fast.next!=null&&fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		//reverse slow.next
		slow.next= reverse(slow.next);
		return head;
		
	}
	public ListNode reverse(ListNode head){
		if(head == null||head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		while(head!=null){
			ListNode temp1 = head.next;
			//store next node of dummy
			ListNode temp2 = dummy.next;
			//append to next of dummy
			dummy.next = head;
			dummy.next.next=temp2;
			head=temp1;
		}
		return dummy.next;
	}

}
