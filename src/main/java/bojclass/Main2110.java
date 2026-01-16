package bojclass;

import java.io.*;
import java.util.*;

public class Main2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[N-1] - arr[0];
        int answer = 0;

        while(min <= max) {
            int mid = (min + max) / 2;
            int now = 0;
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (arr[j] - arr[now] < mid) continue;
                now = j;
                count++;
            }
            if (count < C) {
                max = mid - 1;
            }
            else {
                answer = mid;
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
}

