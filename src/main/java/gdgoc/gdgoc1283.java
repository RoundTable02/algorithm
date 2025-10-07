package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            sb.append(process(line)).append("\n");
        }

        System.out.print(sb);
    }

    static Set<Character> shortCuts = new HashSet<>();
    static String process(String line) {
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            char c = Character.toLowerCase(words[i].charAt(0));
            if (!shortCuts.contains(c)) {
                shortCuts.add(c);
                words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1);
                return String.join(" ", words);
            }
        }

        for (int i = 0; i < line.length(); i++) {
            char c = Character.toLowerCase(line.charAt(i));
            if (c != ' ' && !shortCuts.contains(c)) {
                shortCuts.add(c);
                return line.substring(0, i) + "[" + line.charAt(i) + "]" + line.substring(i + 1);
            }
        }

        return line;
    }
}
