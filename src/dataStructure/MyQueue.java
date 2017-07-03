package dataStructure;
import java.util.*;
public class MyQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 private Stack<Integer> stack;
	 private int size;
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        stack = new Stack<Integer>();
	        size=0;
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stack.push(x);
	        size++;
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	    		int res = 0;
	        Stack<Integer> helper = new Stack<Integer>();
	        for(int i=1;i<size;i++){
	        	helper.push(stack.pop());
	        }
	        res= stack.pop();
	        size--;
	        for(int i=0;i<size;i++){
	        	stack.push(helper.pop());
	        }
	        return res;
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	int res = 0;
	        Stack<Integer> helper = new Stack<Integer>();
	        for(int i=1;i<size;i++){
	        	helper.push(stack.pop());
	        }
	        res= stack.peek();
	        for(int i=1;i<size;i++){
	        	stack.push(helper.pop());
	        }
	        return res;
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return size==0;
	    }

}
