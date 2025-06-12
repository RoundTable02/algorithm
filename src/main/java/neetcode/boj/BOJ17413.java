package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        char[] result = new char[line.length()];

        boolean isTag = false;
        int pointer = 0;
        for (int i = 0; i < line.length(); i++) {
            char now = line.charAt(i);
            if (now == '<') {
                // stack 다 result로 집어넣기
                while (!stack.isEmpty()){
                    result[pointer++] = stack.pop();
                }
                result[pointer++] = now;
                isTag = true;
            }
            else if (now == '>') {
                result[pointer++] = now;
                isTag = false;
            }
            else {
                if (isTag) {
                    result[pointer++] = now;
                }
                else {
                    if (now == ' ') {
                        // stack 다 result로 집어넣기
                        while (!stack.isEmpty()) {
                            result[pointer++] = stack.pop();
                        }
                        result[pointer++] = now;
                    }
                    else {
                        stack.push(now);
                    }
                }
            }
        }
        // 남은 stack 다 result로 집어넣기
        while (!stack.isEmpty()) {
            result[pointer++] = stack.pop();
        }


        System.out.println(result);
    }
}
