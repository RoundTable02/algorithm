package bojclass;

import java.io.*;
import java.util.*;

public class Main15666 {
    static int N, M;
    static int[] arr;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        N = set.size();
        arr = new int[N];
        int k = 0;
        for (int s: set) {
            arr[k++] = s;
        }

        Arrays.sort(arr);

        backtrack(0, 0, new int[M]);

        System.out.println(result);
    }

    static void backtrack(int depth, int before, int[] cur) {
        if (depth == M) {
            for (int t: cur) {
                result.append(t).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = before; i < N; i++) {
            cur[depth] = arr[i];
            backtrack(depth + 1, i, cur);
        }
    }
}
