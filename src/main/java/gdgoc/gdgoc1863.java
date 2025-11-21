package gdgoc;

// stack을 이용
// 직전 H < 현재 H -> push
// 직전 H > 현재 H -> 커질 때까지 pop & count++
// 직전 H == 현재 H -> 무시

import java.io.*;
import java.util.*;

public class gdgoc1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 현재 높이보다 큰 값 pop
            while (!stack.isEmpty() && stack.peek() > y) {
                if (stack.peek() != 0) count++;
                stack.pop();
            }

            // 스택이 비었거나 더 큰 높이면 push
            if (y > 0 && (stack.isEmpty() || stack.peek() < y)) {
                stack.push(y);
            }
        }

        // 남은 건물들 카운트
        while (!stack.isEmpty()) {
            if (stack.peek() != 0) count++;
            stack.pop();
        }

        System.out.println(count);
    }
}