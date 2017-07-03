package easy;

public class FindDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public char findTheDifference(String s, String t) {
	        int a = 0;
	        int b = 0; 
	        for(char c:s.toCharArray()){
	            b =b+c;
	        }
	        for(char c:t.toCharArray()){
	            a=a+ c;
	        }
	        return (char)(a-b);
	    }

}
