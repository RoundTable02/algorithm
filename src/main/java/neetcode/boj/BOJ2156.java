package neetcode.boj;

import java.util.*;

public class BOJ2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wine = new int[n + 1];
        int[] drink = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            wine[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }
        if (n == 2) {
            System.out.println(wine[1] + wine[2]);
            return;
        }

        drink[1] = wine[1];
        drink[2] = drink[1] + wine[2];

        for (int i = 3; i < n + 1; i++) {
            drink[i] = Math.max(
                    Math.max(drink[i - 1], // 마시지 않는 경우
                            drink[i - 2] + wine[i]), // 전전 잔을 마시고 현재 잔을 마시는 경우
                    drink[i - 3] + wine[i - 1] + wine[i] // 연속으로 마시는 경우
            );
        }

        System.out.println(drink[n]);
    }
}
