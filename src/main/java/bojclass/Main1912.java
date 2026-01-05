package bojclass;

import java.io.*;
import java.util.*;

public class Main1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] psum = new int[N + 1];
        int[] low = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            psum[i] = psum[i - 1] + num;
            if (psum[low[i-1]] > psum[i]) {
                low[i] = i;
            }
            else {
                low[i] = low[i-1];
            }
        }

        if (N == 1) {
            System.out.println(psum[1]);
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, psum[i] - psum[low[i - 1]]);
        }

        System.out.println(max);
    }
}
