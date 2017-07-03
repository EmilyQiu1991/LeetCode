package easy;

public class ExcelTitleToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(53));
	}
	 public int titleToNumber(String s) {
		 //scan title from left to right
		 int res = 0;
		 for(int i=0;i<s.length();i++){
			 int value = s.charAt(i)-'A'+1;
			 res = res*26+value;
		 }
		 return res;
	 }
	 public static String convertToTitle(int n) {
		    String s = "";
		    while(n!=0){
		    	int r = n%26;
		    	n = n/26;
		    	if(r==0){
		    		s='z'+s;
		    		n--;
		    	}else{
		    		s=(char)('A'+r-1)+s;
		    	}
		    	
		    }
		    return s;
	    }
	 public int helper(int[] nums, int start, int end){
	        int n = end-start+1;
	        int[] f = new int[n];
	        //init
	        f[0] = nums[start];
	        f[1] = Math.max(f[start], nums[start+1]);
	        for(int i = start+2; i< =end; i++){
	            f[n] = Math.max(f[i-2]+nums[i], f[i-1]);
	        }
	        return f[n-1];
	    }

}
