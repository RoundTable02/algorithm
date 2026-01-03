package bojclass;

import java.io.*;
import java.util.*;

public class Main1759 {
    static char[] secrets;
    static int L;
    static int C;
    static StringBuilder result = new StringBuilder();
    static Set<Character> vowels = new HashSet<>();

    public static void main(String[] args) throws IOException {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        secrets = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            secrets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(secrets);

        backtrack("", 0, 0);

        System.out.println(result);
    }

    static void backtrack(String secret, int now, int vowel) {
        if (secret.length() == L && vowel >= 1 && secret.length() - vowel >= 2) {
            result.append(secret).append("\n");
            return;
        }
        else if (now >= C) return;

        int nextVowel = vowel;
        if (vowels.contains(secrets[now])) nextVowel++;
        String next = secret + secrets[now];
        backtrack(next, now + 1, nextVowel);
        backtrack(secret, now + 1, vowel);
    }
}
