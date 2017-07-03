package easy;

public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWord rw= new ReverseWord();
		System.out.println(rw.reverseWords(" a b"));
		System.out.println("b  a");
		String s="the sky is blue";
		
		System.out.println(reverseWords2(s));
	}
	public String reverseWords(String s) {
        if(s==null||s.length()==0) return s; 
       String[] words=s.split(" ");
        
       
        StringBuilder sb= new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
           if(!words[i].equals("")){
        	   sb.append(words[i]).append(" ");
           }
          
        }
        return sb.toString();
    }
    public void swap(int i,int j, String[] words){
        String temp=words[i];
        words[i]=words[j];
        words[j]=temp;
    }
    public static String reverseWords3	(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; --i) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        //remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
    public static String reverseWords2(String str) {
    	char[] s=str.toCharArray();
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
        return new String(s);
    }

    public static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
  
    


}
