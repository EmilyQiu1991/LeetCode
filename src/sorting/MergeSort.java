package sorting;

import java.util.Arrays;

/**
 * @author qiuyu
 * divide the arr in halves, sort the left half, sort the right half, merge them
 */
public class MergeSort {

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] nums= {3,1,2};
		m.mergeSort(nums);
	}
	public void mergeSort(int[] nums){
		int[] temp = new int[nums.length];
		mergeSort(nums, temp, 0,nums.length-1);
		System.out.println(Arrays.toString(temp));
	}
	private void mergeSort(int[] nums, int[] temp, int left, int right) {
		if(left<right){
			int middle = left+(right-left)/2;
			mergeSort(nums,temp, left,middle);
			mergeSort(nums,temp,middle+1,right );
			merge(nums, temp, left,middle,right);
		}
	}
	private void merge(int[] nums, int[] temp, int leftStart, int middle, int rightEnd) {
		int leftEnd = middle, rightStart=middle+1;
		int index = leftStart;
		while(leftStart<=leftEnd&&rightStart<=rightEnd){
			if(nums[leftStart]<=nums[rightStart]){
				temp[index]=nums[leftStart];
				leftStart++;
			}else{
				temp[index]=nums[rightStart];
				rightStart++;
			}
			index++;
		}
		while(leftStart<=leftEnd){
			temp[index]=nums[leftStart];
			leftStart++;
			index++;
		}
		while(rightStart<=rightEnd){
			temp[index]=nums[rightStart];
			rightStart++;
			index++;
		}
	}
	
	

}
