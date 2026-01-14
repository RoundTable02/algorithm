package bojclass;

import java.io.*;
import java.util.*;

public class Main1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // start
            arr[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int lastEnd = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= lastEnd) {
                lastEnd = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
