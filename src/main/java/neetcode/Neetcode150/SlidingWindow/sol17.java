package neetcode.Neetcode150.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class sol17 {
    // 현재 윈도우에서 가장 많이 등장한 char의 빈도
    // 윈도우 사이즈 - 빈도 = 바꿔야하는 char 수
    // error 사이즈 초과 -> 윈도우 한칸 옮기고 빠진 문자의 빈도 줄이기 그 다음 문자가 최대 빈도인지 확인
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int window = 0;
        int maxFrequency = 0;
        int l = 0;
        int maxSize = 0;

        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            Integer count = counts.get(s.charAt(i));
            maxFrequency = Math.max(maxFrequency, count);

            window = i - l + 1;
            int error = window - maxFrequency;
            if (error > k) {
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l++;
            }
            else {
                maxSize = Math.max(maxSize, window);
            }
        }

        return maxSize;
    }

}
