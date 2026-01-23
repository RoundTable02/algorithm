package programmers;

import java.util.*;

class Solution77486 {
    Map<String, String> refer = new HashMap<>();
    Map<String, Integer> finAmt = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        refer.put("-", "-");
        finAmt.put("-", 0);
        for (int i = 0; i < enroll.length; i++) {
            refer.put(enroll[i], referral[i]);
            finAmt.put(enroll[i], 0);
        }
        for (int i = 0; i < seller.length; i++) {
            settle(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = finAmt.get(enroll[i]);
        }
        return answer;
    }

    int settle(String target, int amount) {
        if (target.equals("-") || amount < 1) return 0;

        int passUp = amount / 10;
        int keep = amount - passUp;

        finAmt.put(target, (int) (finAmt.get(target) + keep));

        return settle(refer.get(target), passUp);
    }
}