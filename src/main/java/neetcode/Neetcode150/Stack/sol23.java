package neetcode.Neetcode150.Stack;

import java.util.Stack;

public class sol23 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                Integer second = stack.pop();
                Integer first = stack.pop();

                int now = first + second;
                stack.push(now);
            } else if (token.equals("-")) {
                Integer second = stack.pop();
                Integer first = stack.pop();

                int now = first - second;
                stack.push(now);
            } else if (token.equals("*")) {
                Integer second = stack.pop();
                Integer first = stack.pop();

                int now = first * second;
                stack.push(now);
            } else if (token.equals("/")) {
                Integer second = stack.pop();
                Integer first = stack.pop();

                int now = first / second;
                stack.push(now);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
