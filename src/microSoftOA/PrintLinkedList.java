package microSoftOA;

import easy.SortedListToBST.ListNode;
import java.util.*;
public class PrintLinkedList {

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		first.next=second;
		ListNode third = new ListNode(3);
		second.next = third;
		ListNode forth = new ListNode(4);
		third.next = forth;
		ListNode fifth = new ListNode(5);
		forth.next = fifth;
		ListNode sixth = new ListNode(6);
		fifth.next = sixth;
		sixth.next = third;
		
		PrintLinkedList p = new PrintLinkedList();
		p.printLinkedList(first);
	}
	public void printLinkedList(ListNode list){
		Set<ListNode> set = new HashSet<ListNode>();
		while(list!=null){
			if(set.contains(list)){
				break;
			}
			System.out.println(list.val);
			set.add(list);
			list = list.next;
		}
	}
	

}
