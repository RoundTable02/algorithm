package neetcode.boj;

import java.util.*;
import java.io.*;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int l = 0;
        int r = max;

        while (l < r) {
            int mid = (l + r) / 2;
            int sum = 0;
            for (int h : arr) {
                if (h - mid > 0) {
                    sum += h - mid;
                }
            }

            if (sum < m) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(l - 1);

    }
}
