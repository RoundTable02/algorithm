package gdgoc;

import java.util.Scanner;

public class gdgoc9655 {
    public static void main(String[] args) {
        // sk, cy, sk, cy, sk
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] arr = new boolean[N + 4];

        arr[0] = true;
        arr[2] = true;
        arr[4] = true;

        if (N <= 5) {
            System.out.println(arr[N - 1] ? "SK" : "CY");
            return;
        }

        for (int i = 5; i < N; i++) {
            arr[i] = !arr[i - 3];
        }

        System.out.println(arr[N - 1] ? "SK" : "CY");
    }
}
