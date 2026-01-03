package bojclass;

import java.io.*;
import java.util.*;

public class Main1182 {
    static int N, S;
    static int result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        backtrack(list, 0);

        System.out.println(result);
    }

    static void backtrack(List<Integer> list, int idx) {
        if (idx == N) {
            int hap = 0;
            for (int l: list) {
                hap += l;
            }
            if (hap == S && !list.isEmpty()) result++;
            return;
        }

        list.add(arr[idx]);
        backtrack(list, idx + 1);
        list.remove(list.size() - 1);
        backtrack(list, idx + 1);
    }
}