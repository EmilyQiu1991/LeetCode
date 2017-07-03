package recursiveAndDynamicProgramming;

public class Fib {
	
	public static void main(String[] args) {
		System.out.println(fib(4,new int[5]));
	}
	public static int fib(int n,int[] arr){
		if(n<=3)
		{
			arr[n]=n;
			return arr[n];
		};
		arr[n]= arr[n-1]+arr[n-2];
		return  fib(n-1,arr)+fib(n-2,arr);
	}
	 int DP(int[][] t, int s, int e){
	        if(s >= e) return 0;
	        if(t[s][e] != 0) return t[s][e];
	        int res = Integer.MAX_VALUE;
	        for(int x=s; x<=e; x++){
	            int tmp = x + Math.max(DP(t, s, x-1), DP(t, x+1, e));
	            res = Math.min(res, tmp);
	        }
	        t[s][e] = res;
	        return res;
	    }

}
