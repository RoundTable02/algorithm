package gdgoc;

import java.io.*;

public class gdgoc2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int maxLength = -1;
        String a = "";
        String b = "";

        for (int i = 0; i < n - 1; i++) {
            String now = words[i];
            if(now.length() <= maxLength) continue;
            for (int j = i+1; j < n; j++) {
                String next = words[j];
                if(next.length() <= maxLength) continue;
                int length = prefixLength(words[i], words[j]);

                if(length > maxLength){
                    maxLength = length;
                    a = words[i];
                    b = words[j];
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
    }

    static int prefixLength(String a, String b) {
        int length = Math.min(a.length(), b.length());
        int idx = 0;
        while (idx < length && a.charAt(idx) == b.charAt(idx)) {
            idx++;
        }
        return idx;
    }
}