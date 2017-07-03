package amazonPhoneInterview;

public class CountOneBit {

	public static void main(String[] args) {
		CountOneBit a = new CountOneBit();
		System.out.println(Integer.bitCount(1));
		System.out.println(a.countOne(-1));
	}
	/**
	 * @param n
	 * @return this method has some issue
	 */
	public int countOne(int n){
		int count=0;
		while(n!=0){
			if((n&1)==1){
				count++;
			}
			n=(n>>1);
		}
		return count;
		
	}
	/**
	 * @param n n&(n-1) eliminate last "1" bit Brian Kernighan’s Algorithm
	 * @return 
	 */
	public int countOne2(int n){
		int count=0;
		while(n!=0){
			n=n&(n-1);
			count++;
		}
		return count;
	}
	

}
