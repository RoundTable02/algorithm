package neetcode.boj;

import java.util.*;

public class BOJ2110 {
    static int N;
    static int C;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[N - 1] - arr[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;
            if (canInstall(mid) < C) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }

    private static int canInstall(int distance) {
        int count = 1;
        int last = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[last] >= distance) {
                count++;
                last = i;
            }
        }

        return count;
    }
}
