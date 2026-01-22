package programmers;

import java.util.*;

class Solution77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int unknown = 0;
        int score = 0;
        Set<Integer> set = new HashSet<>();
        for (int w: win_nums) set.add(w);
        for (int l: lottos) {
            if (set.contains(l)) score++;
            else if (l == 0) unknown++;
        }

        int highest = 7 - (score + unknown);
        int lowest = 7 - score;

        if (highest > 6) highest = 6;
        if (lowest > 6) lowest = 6;

        int[] answer = { highest, lowest };
        return answer;
    }
}
