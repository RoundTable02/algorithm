package neetcode.boj;

import java.util.*;
import java.io.*;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n + m];
        int p = 0, q = 0;
        for (int i = 0; i < n + m; i++) {
            if (p >= n) {
                result[i] = B[q++];
            }
            else if (q >= m) {
                result[i] = A[p++];
            }
            else {
                if (A[p] >= B[q]) {
                    result[i] = B[q++];
                }
                else {
                    result[i] = A[p++];
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

    }
}
