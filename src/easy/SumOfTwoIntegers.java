package easy;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		int a=1,b=2;
		while(b!=0){
	            int c=a^b;
	            
	            b=((a&b)<<1);
	            a=c;
	        }
	        
	}

}
