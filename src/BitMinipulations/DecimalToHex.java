package BitMinipulations;

public class DecimalToHex {
	public static void main(String args[]){
		System.out.println(-1%16);
	System.out.println(toHex(-1));
	System.out.println(Integer.toBinaryString(-1));
	}
	
	/**
	 * @param i Each time we take a look at last 4 bits of binary version of the input,
	 * the map that to a hax char , shift the input to the right by 4 bits, repeat that process until input becomes 0
	 * @return
	 */
	public static String toHex(int i){
		if(i==0) return "0";
		String hexRepre="";
		char[] hex={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		//keep deviding i by 16 to get last 4 bit of binary representaion of i iteratively  , convert it to hex representaion
		while(i!=0){
			//This line very tricky, I used i%16 to get the index in hax, but it seems like if i
			//is negative, it doesn't work, because -1%16=-1,cause indexoutofboundException,
			//so other's use i&111 to get the last four bits,this seems workfor negative number
			//hexRepre=hex[i%16]+hexRepre;
			hexRepre=hex[i&15]+hexRepre;//get last 4 bits,clear other bits to 0
			i=i>>>4;
			System.out.println(Integer.toBinaryString(i));
		}
		return hexRepre;
	}
}
