package algorithm;

import easy.SortedListToBST.ListNode;

public class Merge {

	public static void main(String[] args) {

	}
	public ListNode mergeKLists(ListNode[] lists) {
		return sort(lists, lists.length-1);
	}
	
	public ListNode sort(ListNode[] lists, int last){
		int i=0, j = last;
		while(last !=0){
			while(i<j){
				lists[i]=mergeTwoLists(lists[i],lists[j]);
				i++;
				j--;
			}
			if(i>=j){
				last = j;
			}
		}
		return lists[0];
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode cur=node;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                ListNode temp=l1.next;
                cur.next=l1;
                l1=temp;
            }else{
                ListNode temp=l2.next;
                cur.next=l2;
                l2=temp;
            }
            cur=cur.next;
        }
        while(l1!=null){
             ListNode temp=l1.next;
                cur.next=l1;
                l1=temp;
             cur=cur.next;
        }
         while(l2!=null){
              ListNode temp=l2.next;
              cur.next=l2;
              l2=temp;
             cur=cur.next;
        }
        return node.next;
    }

}
