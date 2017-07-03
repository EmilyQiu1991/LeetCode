package easy;
import java.util.*;
public class PostifixNotation {

	public static void main(String[] args) {
		String[] input = {"2","3","5","*","+"};
		PostifixNotation a = new PostifixNotation();
		System.out.println(a.postfixNotaion(input));
	}
	public int postfixNotaion(String[] arr){
		if(arr==null ||arr.length==0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int res=0;
		for(int i=0;i<arr.length;i++){
			if(isNumeric(arr[i])){
				stack.push(Integer.parseInt(arr[i]));
			}else if(isOperator(arr[i])){
				try{
					int right=stack.pop();
					int left=stack.pop();
					res=compute(arr[i],left,right);
					stack.push(res);
				}catch(EmptyStackException e){
					throw new IllegalArgumentException("IllegalArgument");
				}
			}else{
				throw new IllegalArgumentException("IllegalArgument");
			}
		}
		return res;
	}
	
	public boolean isNumeric( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch( Exception e )
	   {
	      return false;
	   }
	}
	public boolean isOperator(String s){
		return (s.equals("+")||s.equals("-")||s.equals("*"));
	}
	public int compute(String operation, int left, int right){
		if(operation.equals("+")){
			return left+right;
		}else if(operation.equals("*")){
			return left*right;
		}else{
			return left-right;
		}
		
			
	}

}
