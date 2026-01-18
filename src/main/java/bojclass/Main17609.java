package bojclass;

import java.io.*;

public class Main17609 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            System.out.println(palindrome(0, s.length() - 1, s, 0));
        }
    }

    static int palindrome(int l, int r, String s, int chance) {
        // palindrome: 0
        // pseudo palindrome: 1,
        // nothing: 2
        if (chance > 2) return 2;

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {
                return Math.min(palindrome(l + 1, r, s, chance + 1), palindrome(l, r - 1, s, chance + 1));
            }
        }

        return chance;
    }
}

