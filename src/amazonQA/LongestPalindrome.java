package amazonQA;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public String longestPalindrome(String s) {
		 	int maxLen = 0;
		 	int low = 0;
			//corner case
			if(s.length()<=1) return s;
		        for(int i=0;i<s.length();i++){
		        	//assume odd number try to extend Palindrome as possible ex :cabac	
		        int oddLength=search(s,i,i);//
		        if(oddLength>maxLen){
		        	maxLen = oddLength;
		        	low = i-maxLen/2;
		        }
		        int evenLength=search(s,i,i+1);//abba assume even number try to extend Palindrome as possible
		        if(evenLength>maxLen){
		        	maxLen = evenLength;
		        	low = i-maxLen/2+1;
		        }
		        }
		        return s.substring(low, low+maxLen);
		    }
			private int search(String s, int i, int j) {
				while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
					i--;
					j++;
				}
				return j-i-1;
				/*if(j-i-1>maxLen){
					maxLen=j-i-1;
					low=i+1;//note here is i+1 not o
				}*/
			}

}
