package neetcode.Neetcode150.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class sol24 {
    public static List<String> generateParenthesis(int n) {
        Stack<String[]> stack = new Stack<>();
        // used open, available close, data
        stack.push(new String[]{"1", "1", "("});
        List<String> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            String[] pop = stack.pop();
            int open = Integer.parseInt(pop[0]);
            int close = Integer.parseInt(pop[1]);
            String now = pop[2];

            if (n == open && close == 0) {
                result.add(now);
            }

            if (close != 0) {
                stack.push(new String[]{String.valueOf(open), String.valueOf(close - 1), now + ")"});
            }
            if (open != n) {
                stack.push(new String[]{String.valueOf(open + 1), String.valueOf(close + 1), now + "("});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
