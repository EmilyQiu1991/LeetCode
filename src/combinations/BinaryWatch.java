package combinations;
import java.util.*;
public class BinaryWatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryWatch b = new BinaryWatch();
		List<String> res=b.readBinaryWatch(2);
		for(String s : res){
			System.out.print(s+" ");
		}
		
	}
	public List<String> readBinaryWatch(int num) {
		int[] nums1 = {1,2,4,8};
		int[] nums2 = {1,2,4,8,16,32};
		List<String> res = new ArrayList<String>();
		for(int i=0;i<nums1.length&&i<=num;i++){
			List<Integer> h = generateDigit(nums1,i);
			List<Integer> m = generateDigit(nums2,num-i);
			for(int k:h){
				if(k>=12) continue; 
				for(int j:m){
					if(j>=60) continue; 
					if(j<10){
						res.add(k+":0"+j);
					}else{
						res.add(k+":"+j);
					}
				}
			}
		}
	    return res;   
    } 
	public List<Integer> generateDigit(int[] nums, int count){
		List<Integer> res  = new ArrayList<Integer>();
		generateDigitHelper(res,nums,count,0,0);
		return res;
	}
	private void generateDigitHelper(List<Integer> res, int[] nums, int count, int sum,int pos) {
		if(count==0){
			res.add(sum);
			return;
		}
		for(int i=pos;i<nums.length;i++){
			generateDigitHelper(res,nums,count-1,sum+nums[i],i+1);
		}
	}
	 

}
