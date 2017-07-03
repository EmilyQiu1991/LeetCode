package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qiuyu
 * when doing two pointers problems, 
 * 1.remember to sort nums firstly
 * 2.initialize l = i+1, r= nums.length-1
 * 3.If the ask is find all satified result, if satisfy condition, remember to l++, right-- to search more possible result
 */
public class SumOf3 {

	public static void main(String[] args) {
		int[] arr={0,-4,-1,-4,-2,-3,2};//{-4,-1,-1,0,1,2}
		List<List<Integer>> result = threeSum2(arr);
		for(List<Integer> list:result){
			System.out.println(list.toString());
		}

	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		List<Integer> ThreeNums;
        Arrays.sort(nums);
        int[] noDuplicateNums= nums;
        int first=0,second=0;
        for(int i=0;i<noDuplicateNums.length-2;i++){
        	if(i>0&&noDuplicateNums[i]==noDuplicateNums[i-1]) continue;//this is continue,not break;
        	first=noDuplicateNums[i];
        	for(int j=i+1;j<noDuplicateNums.length-1;j++){
        		if(!(j>i+1&&noDuplicateNums[j]==noDuplicateNums[j-1])) {
        		second = noDuplicateNums[j];
        		
        		int thirdIndex=binarySearch(noDuplicateNums,-(first+second),j+1,noDuplicateNums.length-1);
        		if(thirdIndex!=-1){
        			ThreeNums=new ArrayList<Integer>();
        			ThreeNums.add(first);
        			ThreeNums.add(second);
        			ThreeNums.add(noDuplicateNums[thirdIndex]);
        			result.add(ThreeNums);
        		}
        		}
        			
        	}
     
        }
        return result;
    }
	public static int binarySearch(int[] nums,int val,int start,int end){
		if(start>end) return -1;
		int mid=(start+end)/2;//this is not nums.length/2, remember start end index,
		if(nums[mid]==val) return mid;//Note, this is nums[mid], the number of the array, mid==val, not the index
		
		if(val>nums[mid]){
			return binarySearch(nums,val,mid+1,end);//note, this is mid+1, not start+1
		}else{
			return binarySearch(nums,val,start,mid-1);//note,this is mid-1,not start -1,start is not 0, not search from nums[0]
		}
		
	}
	//other's solution
		public static int[] removeDuplicates(int[] A,int n){
			if(n<2) return A;
			int index=1;
			for(int i =1;i<n;i++){
				if(A[i]!=A[i-1]) A[index++]=A[i];
			}
			return Arrays.copyOfRange(A, 0, index);
		}
		public static List<List<Integer>> threeSum2(int[] nums) {
		      List<List<Integer>> result= new ArrayList<List<Integer>>();
		      List<Integer> list;
			  Arrays.sort(nums);
			  for(int i=0;i<nums.length-2;i++){
			      if(i==0||nums[i]!=nums[i-1]){//this if condition also to avoid duplicates in result
			          int l=i+1,r=nums.length-1;
			          while(l<r){
			        	  //these 2 while is to avoid duplicate in result
			              while(l<r&&nums[l+1]==nums[l]){//mistake one, l<r must have , or there will be outofindex
			                  l++;
			              }
			              while(r>l&&nums[r-1]==nums[r]){
			                  r--;
			              }
			              int sum=nums[i]+nums[l]+nums[r];
			              if(sum==0){//if find that 3 numbers. l++,r--, must have, to search more solution, or there will be stackoverflow
			                  list=new ArrayList<Integer>();
			                  list.add(nums[i]);
			                  list.add(nums[l]);
			                  list.add(nums[r]);
			                  result.add(list);
			                  l++;
			                  r--;
			              }else if(sum>0){
			                  r--;
			              }else{
			                  l++;
			              }
			          }
			      } 
			  }
			  return result;
		    }
		
	/**
	 * @param nums Given an array of n integers nums and a target, 
	 * find the number of index triplets i,j,k with 0<=i<j<k<n that satisfy the condition nums[i]+nums[j]+nums[k]<target
	 * 	 * @return
	 */
	public static int threeSumSmaller(int[] nums,int target){
		if(nums==null||nums.length==0) return 0;
		int res = 0;
		Arrays.sort(nums);
		List<Integer> list;
		for(int i=0;i<nums.length-2;i++){
			//2 pointers
			int l=i+1,r=nums.length-1;
			int sum=nums[i]+nums[l]+nums[r];
			while(l<r){
				if(sum<target){//add all elment from l-r to res
					res+=l-r;
					l++;
				}else{
					r--;
				}
			}
		}
		return res;
	}
	 public int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	         if(nums==null||nums.length<3) return 0;
	         int res=nums[0]+nums[1]+nums[2];
	         for(int i=0;i<nums.length-2;i++){
	             int l=i+1,r=nums.length-1;
	             while(l<r){
	                 int temp = nums[i]+nums[l]+nums[r];
	                 if(Math.abs(res-target)>Math.abs(temp-target)){
	                     res=temp;
	                 }
	                 if(temp-target==0){
	                     return temp;
	                 }else if(temp>target){
	                     r--;
	                 }else{
	                     l++;
	                 }
	             }
	         }
	         return res;
	    }
}
