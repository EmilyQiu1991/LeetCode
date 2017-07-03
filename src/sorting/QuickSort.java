package sorting;

import java.util.Arrays;

/**
 * @author qiuyu
 * 1. pick a pivot, and partition the array
 * move element make all elements that are smaller than pivot comes before all elements greater than pivot
 * repeatedly partition the array and it's sub array around an element
 * average O(nlogn), worst case O(n^2) 
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr={4,5,3,1,2,3};
		QuickSort q= new QuickSort();
		q.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public void quickSort(int[] arr, int left, int right){
		if(left>=right) return;
		int index = partition(arr,left,right);
		if(index>left){
			quickSort(arr,left,index-1);
		}
		if(index<right){
			quickSort(arr,index+1,right);
		}
	}
	private int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int index=left; //这里注意一定不要写错，index initiate as left
		for(int i=left;i<right;i++){
			if(arr[i]<=pivot){
				swap(arr,i,index);
				index++;
			}
		}
		swap(arr,index,right);//
		return index;
	}
	private void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
	}

}
