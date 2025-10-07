package gdgoc;

import java.util.Scanner;

public class gdgoc1522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        int len = s.length;
        int aCount = 0;
        for (int i = 0; i < len; i++) {
            if (s[i]=='a') aCount++;
        }

        int windowBCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (s[i]=='b') windowBCount++;
        }

        int minWindowBCount = windowBCount;
        for (int i = 1; i < len; i++) {
            if (s[i-1]=='b') {
                windowBCount--;
            }

            if (i + aCount - 1 >= len) {
                if (s[(i + aCount - 1) % len]=='b') {
                    windowBCount++;
                }
            }
            else if (s[i + aCount - 1]=='b') {
                windowBCount++;
            }

            minWindowBCount = Math.min(minWindowBCount, windowBCount);
        }

        System.out.println(minWindowBCount);
    }
}
