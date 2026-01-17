package bojclass;

import java.io.*;
import java.util.*;

public class Main13397 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int min = 0;
        int max = -1;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        while (min < max) {
            int mid = (min + max) / 2;

            if (count(mid) < M) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    static int count(int mid) {
        int min = 10001;
        int max = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > mid) {
                count++;
                min = 10001;
                max = 0;
                i--;
            }
        }

        return count;
    }
}

