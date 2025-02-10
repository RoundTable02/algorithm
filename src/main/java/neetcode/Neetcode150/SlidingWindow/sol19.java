package neetcode.Neetcode150.SlidingWindow;

public class sol19 {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] sArray = new int[58];
        int[] tArray = new int[58];

        for (int i = 0; i < t.length(); i++) {
            sArray[s.charAt(i) - 'A']++;
            tArray[t.charAt(i) - 'A']++;
        }

        int matches = 0;
        for (int i = 0; i < 58; i++) {
            if (tArray[i] != 0 && sArray[i] >= tArray[i]) {
                matches += tArray[i];
            }
        }

        if (matches == t.length())
            return s.substring(0, t.length());

        int minLength = s.length() + 1;
        String minString = "";
        int l = 0;
        for (int r = t.length(); r < s.length(); r++) {
            int index = s.charAt(r) - 'A';
            sArray[index]++;
            if (tArray[index] != 0) {
                if (tArray[index] >= sArray[index]) {
                    matches++;
                }
            }

            while (matches == t.length()) {
                index = s.charAt(l) - 'A';
                sArray[index]--;
                if (tArray[index] > sArray[index]) {
                    if (minLength > r - l + 1) {
                        minLength = r - l + 1;
                        minString = s.substring(l, r + 1);
                    }
                    matches--;
                }
                l++;
            }

        }

        return minString;
    }

    public static void main(String[] args) {
        minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
    }
}
