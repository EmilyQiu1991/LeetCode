package hard;
import java.util.*;
public class TagValidator {

	public static void main(String[] args) {
		TagValidator t = new TagValidator();
		String s = "<DIV><![CDATA[<div>]]></DIV>";
		
		t.isValid("<DIV><![CDATA[<div>]]></DIV>");
		System.out.println(s.length());
	}
	//given a code snippet
	public boolean isValid(String code){
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<code.length();){
			//Code must be wrapped in a valid closed tag
			if(i>0&&stack.isEmpty()){
				return false;
			}
			if(code.startsWith("<![CDATA[",i)){
				System.out.println("<![CDATA[:"+i);
				int j= i+9;
				//search first subsequent ]]>
				i = code.indexOf("]]>", j);
				if(i<0){
					return false;
				}
				i = i+3;
			}else if(code.startsWith("</", i)){
				System.out.println("</:"+i);
				int j=i+2;
				//search >
				i = code.indexOf(">",j);
				//has length in range [1,9]
				if(i<0||i==j||i-j>9){
					return false;
				}
				//TAG_NAME only contain upper-case letters
				for(int k=j;k<i;k++){
					if(!Character.isUpperCase(code.charAt(k))){
						return false;
					}
				}
				String string= code.substring(j, i);
				if(stack.isEmpty()||!stack.pop().equals(string)){
					return false;
				}
				i++;
			}else if(code.startsWith("<",i)){
				System.out.println("<:"+i);
				int j=i+1;
				//search >
				i = code.indexOf(">",j);
				//has length in range [1,9]
				if(i<0||i==j||i-j>9){
					return false;
				}
				//TAG_NAME only contain upper-case letters
				for(int k=j;k<i;k++){
					if(!Character.isUpperCase(code.charAt(k))){
						return false;
					}
				}
				String string= code.substring(j, i);
				stack.push(string);
				i++;
			}else{
				i++;
			}
			
		}
		return stack.isEmpty();
	}
	

}
