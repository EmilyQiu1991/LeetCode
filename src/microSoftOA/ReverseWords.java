package microSoftOA;

public class ReverseWords {

	public static void main(String[] args) {
		String s=reverse(" Let's take  LeetCode contest");
		System.out.println(s);
		s.trim();
		StringBuilder s = new StringBuilder();
		
	}
	//Let's take LeetCode contest
	//s'teL ekat edoCteeL tsetnoc
	//this method can handle where there is leading space and more then 1 spaces between words
	public static String reverse(String s){
		char[] arr = s.toCharArray();
		for(int i=0;i<arr.length;){
			if(s.charAt(i)!=' '){
				int j = s.indexOf(' ',i+1);
				if(j==-1){
					j=s.length();
				}
				reverse(arr,i,j-1);
				i=j;
			}else{
				i++;
			}
		}
		return String.valueOf(arr);
	}
	private static void reverse(char[] s, int start, int end) {
		 while(start<end){
	            char temp=s[start];
	            s[start]=s[end];
	            s[end]=temp;
	            start++;
	            end--;
	        }
	}
	

}
