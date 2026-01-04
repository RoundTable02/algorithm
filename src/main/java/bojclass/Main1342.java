package bojclass;

import java.io.*;
import java.util.*;

public class Main1342 {
    static int[] alpha = new int[27];
    static String target;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();

        for (int i = 0; i < target.length(); i++) {
            alpha[target.charAt(i) - 'a']++;
        }

        backtrack(' ', 0);

        System.out.println(result);
    }

    static void backtrack(char prev, int depth) {
        if (depth == target.length()) {
            result++;
            return;
        }

        for (int i = 0; i < 27; i++) {
            if (alpha[i] != 0 && prev != (char) (i + 'a')) {
                alpha[i]--;
                backtrack((char) (i + 'a'), depth + 1);
                alpha[i]++;
            }
        }
    }
}
