package gdgoc;

import java.util.Scanner;

public class gdgoc2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == 1) {
            System.out.println(1);
            return;
        }

        int n = 1;
        float left = (float) (x - 7) / 3;
        float right = (float) (x - 2) / 3;
        while (true) {
            if (n * (n-1) >= left && n * (n - 1) <= right) {
                break;
            }
            if (n * (n - 1) > right) {
                n--;
                break;
            }
            n++;
        }

        System.out.println(n + 1);
    }
}
