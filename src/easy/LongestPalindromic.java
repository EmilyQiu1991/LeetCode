package easy;

public class LongestPalindromic {
	private int maxLen=0;
	private int low=0;
	public String longestPalindrome(String s) {
	//corner case
		if(s.length()<=1) return s;
        for(int i=0;i<s.length();i++){
        	search(s,i,i);//assume odd number
        	search(s,i,i+1);//assume even number
        	
        }
        return s.substring(low, low+maxLen);
    }
	private void search(String s, int i, int j) {
		while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
			i--;
			j++;
		}
		if(j-i-1>maxLen){// the length of string is j-i-1 not j-i+1, because while loop 
			maxLen=j-i-1;
			low=i+1;//note here is i+1 not o
		}
	}
	public boolean isPalindrome(String s){
		char[] chars= s.toCharArray();
		int head=0,tail=chars.length-1;
		while(head<tail){
			if(chars[head]!=chars[tail]){
				return false;
			}
			head++;
			tail--;
		}
		return true;
	}

}
