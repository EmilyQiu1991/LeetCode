/**
 * 
 */
package dataStructure;

import java.util.LinkedList;

/**
 * @author qiuyu
 * This class implments A Stack class using LinkedList
 */
public class MyStack {
	private LinkedList list= new LinkedList();
	public void push(Object obj){
		//add given element to the head of the list
		list.addFirst(obj);//note, using addFirst() here ,not add()
	}
	public Object pop(){
		//remove and return the first element in the list
	 return list.removeFirst();
	}
	public boolean isEmpty(){
		
		return list.isEmpty();
	}
	public Object peek(){
		//return the first elment in the list
		return list.getFirst();
	}
}




