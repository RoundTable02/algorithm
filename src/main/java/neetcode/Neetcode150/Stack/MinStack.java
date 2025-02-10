package neetcode.Neetcode150.Stack;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        int min = !minStack.isEmpty() ? Math.min(minStack.peek(), val) : val;
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        minStack1.getMin();
        minStack1.pop();
        minStack1.top();
    }
}
