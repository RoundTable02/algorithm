package gdgoc;

import java.util.*;

public class gdgoc15989 {
    public static void main(String[] args) {
        int[] arr = new int[10001];
        Arrays.fill(arr, 1);
        for (int i = 2; i < 10001; i++) {
            arr[i] += arr[i - 2];
        }
        for (int i = 3; i < 10001; i++) {
            arr[i] += arr[i - 3];
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }
    }
}
