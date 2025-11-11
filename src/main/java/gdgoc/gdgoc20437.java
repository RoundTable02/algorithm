package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<Integer>[] alpha = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                alpha[i] = new ArrayList<>();
            }

            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i) - 'a'].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int i = 0; i < 26; i++) {
                if (alpha[i].size() < K) continue;

                List<Integer> list = alpha[i];
                for (int j = 0; j + K - 1 < list.size(); j++) {
                    int len = list.get(j + K - 1) - list.get(j) + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }

            if (max == -1) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}
