package neetcode.Neetcode150.Stack;

import java.util.Stack;

public class sol27 {
    public int largestRectangleArea(int[] heights) {
        // leftIndex, height
        Stack<Integer[]> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                Integer[] pop = stack.pop();
                int width = i - pop[0];
                max = Math.max(max, width * pop[1]);
                start = pop[0];
            }
            stack.push(new Integer[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            Integer[] pop = stack.pop();
            int width = heights.length - pop[0];
            max = Math.max(max, width * pop[1]);
        }

        return max;
    }
}
