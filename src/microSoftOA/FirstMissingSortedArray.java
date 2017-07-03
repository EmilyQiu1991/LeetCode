package microSoftOA;

public class FirstMissingSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMissing(new int[]{0, 1}));
	}
	//
	public static int findMissing(int[] nums){
		int start = 0, end = nums.length-1;
		while(start<end){
			int mid = start+(end-start)/2;
			if(nums[mid]-nums[start]!=mid-start){
				//there is a hole in first half
				if(mid-start==1){
					return nums[start]+1;
				}
				end = mid;
			}else if(nums[end]-nums[mid]!=end-mid){
				if(end-mid==1){
					return nums[mid]+1;
				}
				start=mid;
			}else{
				return -1;
			}
		}
		return -1;
	}

}
