package bojclass;

import java.io.*;
import java.util.*;

public class Main2805 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cur = 0;
        int step = Integer.MAX_VALUE;

        while (step > 0) {
            while (true) {
                int height = cur + step;
                long rest = 0;

                for (int tree: arr) {
                    if (tree > height) rest += tree - height;
                }

                if (rest < M) break;

                cur = height;
            }
            step /= 2;
        }

        System.out.println(cur);
    }
}

