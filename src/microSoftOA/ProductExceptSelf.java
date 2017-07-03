package microSoftOA;

public class ProductExceptSelf {

	public static void main(String[] args) {

	}
	public int[] productExceptSelf(int[] nums){
		if(nums==null||nums.length==0)
		    return new int[0];
		//store the product elements before i
		//example product_before[i] is product[0]*product[1]*product[2]*... product[i-1] which is product[i-1]*num[i]
		int[] product_before = new int[nums.length];
		//for first element ,there is no elements before it, set it as 1
		product_before[0] = 1;
		for(int i=1;i<nums.length;i++){
			product_before[i]=product_before[i-1]*nums[i-1];
		}
		int product_after = 1;
		for(int i = nums.length-1;i>=0;i--){
			product_before[i] *= product_after;
			product_after = product_after*nums[i];
		}
		return product_before;
	}

}
