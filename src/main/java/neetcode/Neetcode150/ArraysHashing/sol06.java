package neetcode.Neetcode150.ArraysHashing;

import java.util.ArrayList;
import java.util.List;

public class sol06 {
    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> sample = new ArrayList<>();
        sample.add("neet");
        sample.add("code");
        sample.add("love");
        sample.add("you");
        decode(encode(sample));
    }
}
