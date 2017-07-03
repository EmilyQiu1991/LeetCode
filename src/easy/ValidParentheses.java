package easy;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		char top;
		for (char c : s.toCharArray()) {
			if (!st.isEmpty()) {
				top = st.peek();
				if (validBracketPair(top, c)) { // the condition is not top == c
					st.pop();
				} else {
					st.push(c);
				}
			} else {
				st.push(c);
			}

		}
		return st.isEmpty();
	}

	public static boolean validBracketPair(char a, char b) {
		return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
	}

	// other's solution
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
