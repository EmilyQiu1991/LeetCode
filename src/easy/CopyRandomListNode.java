package easy;
import java.util.*;
public class CopyRandomListNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
     }
	  public RandomListNode copyRandomList(RandomListNode head) {
	      if(head==null) return null;
	      HashMap<RandomListNode,RandomListNode> map = new  HashMap<RandomListNode,RandomListNode>();
	      RandomListNode newHead = new RandomListNode(head.label);
	      map.put(head, newHead);
	      RandomListNode oldP= head.next;
	      RandomListNode newP= newHead;
	      while(oldP!=null){
	    	  RandomListNode copyNode = new RandomListNode(oldP.label);
	    	  map.put(oldP, copyNode);
	    	 
	    	  newP.next=copyNode;
	    	  oldP=oldP.next;
	    	  newP=newP.next;
	      }
	      //2rd round go through original list
	      oldP=head;
	      newP=newHead;
	      while(oldP!=null){
	    	  newP.random=map.get(oldP.random);
	    	  oldP=oldP.next;
	    	  newP=newP.next;
	      }
	      return newHead;
	}

	

}
