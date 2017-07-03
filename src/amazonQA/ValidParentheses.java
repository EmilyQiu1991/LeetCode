package amazonQA;
import java.util.*;
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean isValid(String s) {
		 	int count =0;
	        Stack<Character> st = new Stack<Character>();
	        char top;
	        for(char c:s.toCharArray()){
	            if(!st.isEmpty()){
	                top = st.peek();
	                if((top=='(' && c==')') || (top=='{' && c=='}') || (top=='[' && c==']')){
	                    st.pop();
	                }else{
	                    st.push(c);
	                }
	            }else{
	                st.push(c);
	            }
	        }
	        return st.isEmpty();
	    }
	   public int isValidParentheses(String s) {
	        if (s == null || s.length() == 0)   return 0;
	        Stack<Character> stack = new Stack<Character>();
	        
	        for (int i = 0; i < s.length(); i++) {
	        	if(s.charAt(i)!='('||s.charAt(i)!=')'){
	        		continue;
	        	}
	            if (stack.empty())  stack.push(s.charAt(i));
	            //in ascii code , ( and ) different 1 , { and }, [ and ] difference is 2
	            else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2)    stack.pop();
	            else    stack.push(s.charAt(i));
	        } 
	        return stack.empty()?s.length()/2:-1;
	    }
	 

}
