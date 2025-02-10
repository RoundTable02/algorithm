package neetcode.Neetcode150.TwoPointers;

public class sol10 {
    public static boolean isPalindrome(String s) {
        String replacedString = s.replaceAll(" ", "").toLowerCase();

        int i = 0;
        int j = replacedString.length() - 1;

        while (i < j) {
            if (!isCharNum(replacedString.charAt(i))) {
                i++;
                continue;
            }

            if (!isCharNum(replacedString.charAt(j))) {
                j--;
                continue;
            }

            if (replacedString.charAt(i) != replacedString.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    public static boolean isCharNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    public static void main(String[] args) {
        isPalindrome("Was it a car or a cat I saw?");
    }
}
