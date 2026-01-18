package bojclass;

import java.io.*;
import java.util.*;

public class Main1806 {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now > S) {
                System.out.println(1);
                return;
            }

            arr[i] = arr[i - 1] + now;
        }

        int l = 0, r = 1;
        int len = Integer.MAX_VALUE;

        while (l <= r && r <= N) {
            int hap = arr[r] - arr[l];
            if (hap < S) {
                r++;
            }
            else {
                len = Math.min(len, r - l);
                l++;
            }
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}

