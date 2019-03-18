package ByteDance;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public MinStack() {
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) stack2.push(x);
    }

    public void pop() {
        int x = stack1.pop();
        if (x == stack2.peek()) stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

}
