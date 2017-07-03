package easy;

public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay a = new CountAndSay();
		System.out.println(a.countAndSay(2));
	}
	 public String countAndSay(int n) {
	        String seq = "1";
	        StringBuilder sb ;
	        for(int i=1;i<=n;i++){
	            char lastDigit=seq.charAt(0);
	            int count=0;
	            sb= new StringBuilder();
	            for(int j=0;j<seq.length();j++){
	                if(seq.charAt(j)==lastDigit){
	                    count++;
	                }
	                else{
	                    sb.append(count).append(lastDigit);
	                    lastDigit=seq.charAt(j);
	                    count=1;
	                }
	            }
	            sb.append(count).append(lastDigit);
	            seq=sb.toString();
	            
	        }
	        return seq;
	    }

}
