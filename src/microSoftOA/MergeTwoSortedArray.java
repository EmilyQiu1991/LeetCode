package microSoftOA;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
		 int tail = m+n-1;
		 //populating nums1 from tail
		 int a = m-1,b=n-1;
		 while(a>=0 && b>=0){
			 if(nums1[a]>nums2[b]){
				 nums1[tail]=nums1[a];
				 a--;
			 }else{
				 nums1[tail]=nums2[b];
				 b--;
			 }
			 tail--;
		 }
		 while(b>=0){
			 nums1[tail]=nums2[b];
			 b--;
		     tail--;
		 }
	 }

}
