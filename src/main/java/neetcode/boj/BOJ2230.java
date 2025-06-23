package neetcode.boj;

import java.util.*;

public class BOJ2230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int min = A[N - 1] - A[0] + 1;
        int p = 0; int q = 1;
        while (q < N) {
            int cha = A[q] - A[p];
            if (cha >= M) {
                if (min > cha) {
                    min = cha;
                }
                if (cha == M) {
                    min = cha;
                    break;
                }
                p++;
            }
            else {
                q++;
            }
        }

        System.out.println(min);
    }
}
