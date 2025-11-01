package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] power = new int[N];
        String[] name = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            int target = Integer.parseInt(br.readLine());
            int i = 0, j = N - 1;
            while (i < j) {
                int m = (i + j) / 2;
                if (power[m] < target) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            sb.append(name[i]).append("\n");
        }

        System.out.println(sb);
    }
}
