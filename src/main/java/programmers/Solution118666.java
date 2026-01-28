package programmers;

import java.util.*;

class Solution118666 {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        char[] types = new char[] {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            char c = survey[i].charAt(0);
            if (choice > 4) {
                choice -= 4;
                c = survey[i].charAt(1);
            }
            else choice = 4 - choice;
            map.put(c, map.getOrDefault(c, 0) + choice);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char c1 = types[i * 2];
            char c2 = types[i * 2 + 1];
            int v1 = map.getOrDefault(c1, 0);
            int v2 = map.getOrDefault(c2, 0);

            if (v1 >= v2) sb.append(c1);
            else sb.append(c2);
        }

        return sb.toString();
    }
}
