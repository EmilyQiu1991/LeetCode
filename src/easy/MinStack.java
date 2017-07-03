package easy;

import java.util.Stack;

public class MinStack {
	private Stack<Long> stack;
	private long min;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<Long>();

	}

	public void push(int x) {// consider if x is -2147483647
		if (stack.isEmpty()) {
			stack.push(0L);
			min = x;
		} else {
			stack.push(x - min);// -2147483647-min can cause overflow
			if (x < min)
				min = x;
		}
	}

	public void pop() {
        if(stack.isEmpty()) return;
        long top = stack.pop();
        if(top<0) min= min-top;
        else return 
    }

	public int top() {
		long top = stack.peek();
		if (top < 0)
			return (int) min;
		else
			return (int) (min + top);
	}

	public int getMin() {
		return (int) min;
	}

	public static void main(String args[]) {
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.printStack();
		minStack.push(2147483646);
		minStack.printStack();
		minStack.push(2147483647);//
		minStack.printStack();

		System.out.println("getTop(): " + minStack.top()); // 2147483647

		minStack.pop();// null
		minStack.printStack();
		System.out.println("getMin(): " + minStack.getMin()); // 2147483646
		minStack.pop();
		minStack.printStack();
		System.out.println("getMin(): " + minStack.getMin());// 2147483646
		minStack.pop();
		minStack.printStack();
		minStack.push(2147483647);
		minStack.printStack();
		System.out.println("getTop(): " + minStack.top());
		System.out.println("getMin(): " + minStack.getMin());
		minStack.push(2147483647);
		minStack.printStack();
		System.out.println("getTop(): " + minStack.top());
		System.out.println("getMin(): " + minStack.getMin());
		minStack.push(-2147483647);
		minStack.printStack();
		System.out.println("getTop(): " + minStack.top());
		System.out.println("getMin(): " + minStack.getMin());
	}

	public void printStack() {
		System.out.print("Stack data:  ");
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + "  ");
		}

		System.out.println("stack min:  " + min);
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
