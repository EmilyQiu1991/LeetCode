package hard;

public class StringTimeConvert {
	 private final String[] LESS_THAN_20 = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
	 private final String[] TENS = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
	public static void main(String[] args) {
		StringTimeConvert s = new StringTimeConvert();
		System.out.println(s.convert(1200));
	}
	public String convert(int time){
		int min = time%100;
		time = time/100;
		int hour = time%100;
		StringBuilder sb = new StringBuilder();
		boolean am = true;
		if(hour<=12){
		 sb.append(LESS_THAN_20[hour]);
		}else{
			sb.append(LESS_THAN_20[hour-12]);
		}
		if(hour>=12){
			am = false;
		}
		sb.append(minToWord(min));
		if(am){
			sb.append(" am");
		}else{
			sb.append(" pm");
		}
		return sb.toString();
		 
	}
	public String minToWord(int min){
		if(min<12){
			return LESS_THAN_20[min];
		}else{
			return  TENS[min/10]+LESS_THAN_20[min%10];
		}
	}

}
