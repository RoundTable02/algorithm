package neetcode.Neetcode150.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class sol26 {
    public static int carFleet(int target, int[] position, int[] speed) {
        // position, speed
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        List<Integer[]> init = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Integer[] car = new Integer[]{position[i], speed[i]};
            init.add(car);
        }

        init.sort((a, b) -> b[0] - a[0]);

        for (Integer[] car : init) {
            stack.push((double) (target - car[0]) / car[1]);

            if (stack.size() >= 2 &&
                    stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(carFleet(10, new int[]{4, 1, 0, 7}, new int[]{2, 2, 1, 1}));
    }

}
