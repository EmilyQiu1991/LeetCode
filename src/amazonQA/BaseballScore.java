package amazonQA;
import java.util.Stack;
/*input can have negative number*/
public class BaseballScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseballScore b = new BaseballScore();
		System.out.println(b.getScore(new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"}));
	}
	//illegal input ,return 0, not -1
	public int getScore(String[] input){
		Stack<Integer> stack = new Stack<Integer>();
		int score = 0;
		for(String s:input){
			if(!isValid(s)){
				return 0;
			}
			if(isNumber(s)){
				int num = Integer.parseInt(s);
				stack.push(num);
				score += num;
			}
			if(s.equalsIgnoreCase("x")){
				//double last value, if there is no last value, take it as 0
				//first pop value, push double value
				if(!stack.isEmpty()){
					int peek = stack.pop();
					score += peek*2;
					stack.push(peek*2);
				}
			}
			if(s.equalsIgnoreCase("+")){
				//first pop top 2 value and add them to score, put them back as it was
				//and also put their sum to stack
				if(stack.size()==0){
					continue;
				}
				if(stack.size()==1){
					score += stack.peek();
				}else{
					int first = stack.pop();
					int second = stack.pop();
					int sum= first +second;
					score += sum;
					stack.push(second);
					stack.push(first);
					stack.push(sum);
				}	
			}
			if(s.equalsIgnoreCase("Z")){
				//remove last value,decrease last score from score
				if(stack.isEmpty()){
					continue;
				}
				int num = stack.pop();
				score = score-num;
				
			}
		}
		return score;
	}
	public boolean isValid(String s){
		if(s.equalsIgnoreCase("+")||s.equalsIgnoreCase("X")||s.equalsIgnoreCase("z")){
			return true;
		}
		if(isNumber(s)){
			return true;
		}
		return false;
	}
	public boolean isNumber(String s){
		try {
			double d = Double.parseDouble(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
