package BitMinipulations;

/**
 * @author qiuyu
 * this class will provide a solution of how to count how many ones in a byte
 */
public class CountOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countOneUsingAnd1((byte) -1));
		System.out.println(((byte)-1)>>>1);
		System.out.println(countOnesUsingAnd((byte) -1));
		
	}
	public int countOnesUsingJavaLibMethod(byte value){
		return 0;
	}
	public static int countOnesUsingAnd(byte value){
		int count=0;
		while(value!=0){
			if((value&1)==1){
				count++;
			}
			value>>>=1;
		}
		return count;
	}
	/**
	 * @param value
	 * this is an optimazation of last method BrianKernighan's algorithem
	 * @return 
	 */
	public static int countOneUsingAnd1(byte value){
		//Initialize count:=0
		int count=0;
		//Repeate this step until n is 0
		while(value!=0){//if interger n is not zero
			//Do bitwise & with (n-1) and assign the value back to N
			value=(byte) (value&(value-1));
			count ++;//increment count by 1
		}
		return count;
	}
}
