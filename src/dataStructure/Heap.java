package dataStructure;

import java.util.Arrays;

public class Heap {
	
	int capacity=10;
	int size=10;
	int item[] = new int[capacity];
	
	public static void main(String[] args) {
	}
	
	private int getLeftChildIndex(int parentIndex){
		return 2*parentIndex+1;
	}
	private int getRightChildIndex(int parentIndex){
		return 2*parentIndex+2;
	}
	private int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}
	private boolean hasLeftChild(int parentIndex){
		return getLeftChildIndex(parentIndex)<size;
	}
	private boolean hasRightChild(int parentIndex){
		return getRightChildIndex(parentIndex)<size;
	}
	private boolean hasParent(int childIndex){
		return getParentIndex(childIndex)>=0;
	}
	private int leftChild(int index){
		return item[getLeftChildIndex(index)];
	}
	private int rightChild(int parentIndex){
		return item[getRightChildIndex(parentIndex)];
	}
	private int parent(int childIndex){
		return item[getParentIndex(childIndex)];
	}
	private void swap(int indexOne, int indexTwo){
		int temp= item[indexOne];
		item[indexOne] = item[indexTwo];
		item[indexTwo]=temp;
	}
	/**
	 * if the array is full, create a new array,
	 * if so, double that size, copy all the elements over 
	 */
	private void ensureExtraCapacity(){
		if(size==capacity){
			item=Arrays.copyOf(item, capacity*2);
		}
		capacity = capacity*2;
	}
	public int peek(){
		if(size==0) throw new IllegalStateException();
		return item[0];
	}
	public int poll(){
		if(size==0) throw new IllegalStateException();
		int min = item[0];
		//move the last element to root
		item[0] = item[size-1];
		size--;
		heapifyDown();
		return min;
	}
	public void add(int val){
		ensureExtraCapacity();
		item[size]=val;
		size++;
		heapifyUp();//swap elements with its parent if necessary
	}
	//adjust our heap
	public void heapifyUp(){
		//start with very last element added
		//as long as there is a parent item and bigger than me
		int index= size-1;
		while(hasParent(index)&&item[index]>parent(index)){
			swap(index,getParentIndex(index));
			index=getParentIndex(index);
		}
	}
	public void heapifyDown(){
		if(size<=1) return;
		int index=0;
//		while((hasLeftChild(index)&&leftChild(index)>item[index])||
//				(hasRightChild(index)&&rightChild(index)>item[index])){
//			if(hasRightChild(index)&&hasLeftChild(index)){
//				swap(index,leftChild(index)>rightChild(index)?getLeftChildIndex(index):getRightChildIndex(index));
//			}else if(hasRightChild(index)){
//				swap(index,getRightChildIndex(index));
//			}else{
//				swap(index,getLeftChildIndex(index));
//			}
//		}
		//check if there is right child, if there is no right child, there definitely is no right child
		while(hasLeftChild(index)){
			int smallerChildIndex=getLeftChildIndex(index);
			if(hasRightChild(index)&&rightChild(index)<leftChild(index)){
				smallerChildIndex = getRightChildIndex(index);
			}
			if(item[0]<item[smallerChildIndex]){
				break;//this is the point can break here , i don't notice this
			}else{
				swap(index,smallerChildIndex);
			}
			index=smallerChildIndex;
		}
	}
	
	
	
}
