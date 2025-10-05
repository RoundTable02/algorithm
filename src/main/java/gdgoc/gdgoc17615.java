package gdgoc;

import java.util.Scanner;

public class gdgoc17615 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        char[] s = sc.nextLine().toCharArray();
        if (N == 1) {
            System.out.println(0);
            return;
        }

        char start = s[N - 1];

        int i = N - 2;
        while (s[i] == start) {
            i--;
            if (i == -1) {
                System.out.println(0);
                return;
            }
        }

        int blue = 0;
        int red = 0;

        for (; i >= 0; i--) {
            if (s[i] == 'B') blue++;
            else red++;
        }

        int right = Math.min(blue, red);

        start = s[0];

        i = 1;
        while (s[i] == start) {
            i++;
            if (i == N) {
                System.out.println(0);
                return;
            }
        }

        blue = 0;
        red = 0;

        for (; i < N; i++) {
            if (s[i] == 'B') blue++;
            else red++;
        }

        int left = Math.min(blue, red);

        System.out.println(Math.min(right, left));
    }
}
