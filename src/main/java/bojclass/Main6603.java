package bojclass;

import java.io.*;
import java.util.*;

public class Main6603 {
    static int[] arr;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while(!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backtrack("", 0, 0);
            result.append("\n");
        }

        System.out.println(result);
    }

    static void backtrack(String cur, int now, int len) {
        if (len == 6) {
            result.append(cur.trim()).append("\n");
            return;
        }
        else if (now >= arr.length) return;

        String next = cur + " " + arr[now];

        backtrack(next, now + 1, len + 1);
        backtrack(cur, now + 1, len);
    }
}