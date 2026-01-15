package bojclass;

import java.io.*;
import java.util.*;

public class Main1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int l = 0, r = N - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] < target) {
                    l = mid + 1;
                }
                else {
                    r = mid;
                }
            }

            System.out.println(arr[l] == target ? 1 : 0);
        }
    }
}

