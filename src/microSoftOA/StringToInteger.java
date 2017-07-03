package microSoftOA;

public class StringToInteger {

	public static void main(String[] args) {
		String str = "-2147483649";
		StringToInteger s = new StringToInteger();
		System.out.println(s.stringToInteger(str));


	}
	public int stringToInteger(String str){
		//corner case
		if(str==null||str.length()==0) return 0;
		long res=0;
		int sign = 1;
		//remove leading white space
		str = str.trim();
		int i =0;
		//deal with sign
		if(str.charAt(i)=='+'){
			sign=1;
			i++;
		}else if(str.charAt(i)=='-'){
			sign=-1;
			i++;
		}
		//deal with digit
		while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){//while loop don't forget index out of range
			int digit=str.charAt(i)-'0';//here , minus char '0'
			res=res*10+digit;
			if(res>Integer.MAX_VALUE) break;
			i++;
		}
		//deal with integer overflow
		if(res*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(res*sign<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return (int)res*sign;//result multiply sign
	}
	

}
