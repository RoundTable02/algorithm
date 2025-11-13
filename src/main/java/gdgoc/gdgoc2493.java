package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if (peek[1] >= now) {
                    result[i] = peek[0];
                    break;
                }
                else stack.pop();
            }
            stack.push(new int[] {i, now});
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) sb.append(r + 1).append(" ");
        System.out.println(sb);
    }
}

