package neetcode.boj;

import java.util.*;

public class BOJ6236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        int sum = 0;
        int min = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            min = Math.max(min, arr[i]);
        }

        int max = sum;

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;
            int money = 0;
            for (int i = 0; i < N; i++) {
                if (money < arr[i]) {
                    count++;
                    money = mid;
                }

                money -= arr[i];
            }

            if (count > M) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        System.out.println(min);
    }

}
