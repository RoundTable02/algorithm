package neetcode.boj;

import java.util.*;

public class BOJ1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long max = 0;
        long min = 0;

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        max++;

        while (max > min) {
            long mid = (max + min) / 2;
            long count = 0;
            for (int lan : arr) {
                count += lan / mid;
            }

            if (count >= N) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }

        System.out.println(min - 1);


    }
}
