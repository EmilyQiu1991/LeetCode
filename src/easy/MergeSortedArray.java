package easy;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1={0};
		int[] nums2={1};
		merge(nums1,2,nums2,1);
		System.out.println(Arrays.toString(nums1));
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a=nums1.length-1,b=nums2.length-1;//a is the pointer for nums1, b is pointer for nums2
        int tail=nums1.length+nums2.length-1;//head3 is for pointer of new Array
        while(a>=0&&b>=0){
            if(nums1[a]>=nums2[b]){
                nums1[tail]=nums1[a];
                a--;
            }else{
                nums1[tail]=nums2[b];
                b--;
            }
            tail--;
        }
        //don't need to care the rest of nums1,it is fine  let them stay where it is
        while(b>=0){
             nums1[tail]=nums2[b];
             tail--;
            b--;
        }
        System.out.println(Arrays.toString(nums1));
    }

}
