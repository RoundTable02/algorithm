package neetcode.Neetcode150.Stack;

import java.util.Stack;

public class sol25 {
    public int[] dailyTemperatures(int[] temperatures) {
        // temperature, index
        Stack<Integer[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                Integer[] pop = stack.pop();
                result[pop[1]] = i - pop[1];
            }
            stack.push(new Integer[]{temperatures[i], i});
        }

        return result;
    }
}
