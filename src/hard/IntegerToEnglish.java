package hard;

public class IntegerToEnglish {

	public static void main(String[] args) {
		IntegerToEnglish i = new IntegerToEnglish();
		System.out.println(i.numberToWords(1000123));
	}
	 private final String[] LESS_THAN_20 = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
	 private final String[] TENS = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
	 private final String[] THOUSANDS = {"", " Thousand", " Million", " Billion"};
	    
    public String numberToWords(int num) {
        String res ="";
        //how many 3 digits chunk
        System.out.println(Math.ceil(String.valueOf(num).length()/3));
        int countOfChunks = (int) Math.ceil(String.valueOf(num).length()/3.0);
        for(int i=0;i<countOfChunks;i++){
        	int value = num%1000;
        	if(value!=0){
        		res = helper(value)+THOUSANDS[i]+res;
        	}
        	num=num/1000;
        }
        return res.length()>0?res.substring(1, res.length()):"Zero";
    }
    //a helper method that takes a numbers less than 1000 and convert just that chunk to words
    public String helper(int num){
        String res = "";
        if(num==0) return res;
    	int value = num%100;
    	if(value>=20){
    		int lessThanTen = value%10;
    		res = LESS_THAN_20[lessThanTen]+res;
    		value = value/10;
    		res = TENS[value]+res;
    	}
    	else{
    		res = LESS_THAN_20[value]+res;
    	}
    	num = num/100;
    	if(num>0){
    		res = LESS_THAN_20[num]+" Hundred"+res;
    	}
    	return res;
        
    }

}
