package medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
	int[] nums = {1,2,3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShuffleAnArray a = new ShuffleAnArray();
		 Random random = new Random();
		 int randomIndex = (int)(random.nextInt(3+1));
		// System.out.println(randomIndex);
		 for(int i=0;i<=10;i++)
		 System.out.println(Arrays.toString(a.shuffle()));
	}
	 public int[] shuffle() {
	        shuffleHelper(nums.length-1);
	        return nums;
	    }
	    public void shuffleHelper(int end){
	        if(end<1) return ;
	        shuffleHelper(end-1);
	        int randomIndex = (int)(Math.random()*(end+1));
	        swap(nums,randomIndex,end);
	        
	    }
	    private void swap(int[] a,int i,int j){
	        int temp = a[i];
	        a[i]=a[j];
	        a[j]=temp;
	    }
	    public void shuffle(){
	    	
	    	for(int i=1;i<nums.length;i++){
	    		int random = (int)(Math.random()*(i+1);
	    		swap(nums,random,i);
	    	}
	    }

}
