package dataStructure;

import java.util.Arrays;

public class MyArrayQueue {
	int[] arr;
	int head = 0;
	int tail = -1;
	int capacity =0;
	int size =0;
	public static void main(String[] args) {

	}
	public MyArrayQueue(){
		arr = new int[10];
		capacity = 10;
	}
	 public void push(int x) {
		 //ensure capacity
		 //add element after tail, update tail
		 arr[(tail+1)%capacity] = x;
		 //update  pointer tail
		 tail=(tail+1)%capacity;
		 size++;
	 }
	
	 public int pop() {
		 int res = arr[head];
		 //move pointer head
		 head = (head+1)%capacity;
		 size--;
		 return res;
	 }
	 //return head directly
	 public int peek() {
		 return arr[head];
	 }
	 public void ensureCapacity(){
		 if(size==capacity){
			    //double array
				arr=Arrays.copyOf(arr, capacity*2);
				//if head is come after tail,need to move them to the end of the arr
				//if head is come before tail, need need to move, continue add element after tail
				if(head>tail){
					//move head to end of arr to end of current arr
					for(int i = capacity-1;i>=head;i--){
						arr[i+capacity]=arr[i];
					}
				}
				//update head, update capacity
				head = head+capacity;
				capacity = capacity*2;
		 }
	 }
	 public int size(){
		 return size;
	 }
}
