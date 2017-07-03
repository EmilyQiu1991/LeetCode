package easy;
import java.util.*;
import easy.SortedListToBST.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head= new ListNode(1);
		head.next=new ListNode(2);
		System.out.println(isPalindrome(head));
	}
	public static boolean isPalindrome(ListNode head) {
        if(head == null ) return true;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode cur=head;
        while(cur!=null){//don't take while as if
            stack.push(cur.val);
            cur=cur.next;
        }
        while(!stack.isEmpty()&&head!=null){
            if(head.val!=stack.pop())  return false;
            head = head.next;
        }
        return true;
        
    }

}
