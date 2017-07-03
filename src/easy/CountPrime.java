package easy;

public class CountPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countPrimes(4);
	}
	 public static int countPrimes(int n) {
		 //start from 2, we know that 2 is Prime than mark multip of 2 as true in notPrime
		 //so the loop of i will skip them, next prime is 3, do the same thing,Then it is 4, which 2*2
		 //so the not prime is true, will skip to next
		 boolean[] notPrime = new boolean[n];
	        int count = 0;
	        for (int i = 2; i < n; i++) {
	            if (notPrime[i] == false) {
	                count++;
	                for (int j = 2; i*j < n; j++) {
	                    notPrime[i*j] = true;
	                }
	            }
	        }
	        
	        return count;
	 }

}
