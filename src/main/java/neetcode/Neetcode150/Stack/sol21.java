package neetcode.Neetcode150.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class sol21 {
    public boolean isValid(String s) {
        Map<Character, Character> dict = new HashMap<>();
        dict.put(']', '[');
        dict.put('}', '{');
        dict.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!dict.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            else if (!stack.isEmpty()) {
                Character top = stack.pop();
                if (top != dict.get(s.charAt(i))) {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
