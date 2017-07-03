package easy;

public class IsPalindrome {

	public static void main(String[] args) {

	}
	 public boolean isPalindrome(String s) {
	        if(s==null||s.length()==0) return true;
	        int head=0,tail=s.length()-1;
	        while(head<tail){
	            if(!Character.isLetterOrDigit(s.charAt(head))){
	            	head++;
	            }
	            if(!Character.isLetterOrDigit(s.charAt(tail))){
	            	tail--;
	            }
	            if(!(Character.toLowerCase(s.charAt(head))==Character.toLowerCase(s.charAt(tail)))){
	            	return false;
	            }
	            head++;
	            tail--;
	        }
	        
	        return true;
	    }

}
