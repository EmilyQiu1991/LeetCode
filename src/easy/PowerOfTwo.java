package easy;

public class PowerOfTwo {

	public static void main(String[] args) {		

	}
	public boolean isPowerOfTwo(int n){
		//keep dividing given n by 2, do n=n/2 iteratively,
		//in any interation, if n%2 becomes ono-zero and n is not 1
		//then n is not power of 2, if n becomes 1 ,n is power of 2
		if(n==0) return false;
		while(n%2==0){
			n=n/2;
		}
		return n==1;
		
	}
	//use the property of if n is power of 2, then the binary representation of 
	//n will only have one  bit which is 1
	public boolean isPowerOfTwoBit(int n){
		if(n<=0) return false;////this is n<=0,need to consider negative N

		if((n&(n-1))==0){
			return true;
		}
		return false;
	}
}
