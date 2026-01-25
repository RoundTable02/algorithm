package programmers;

import java.util.*;

class Solution92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> reporter = new HashMap<>();
        for (String id: id_list) {
            map.put(id, new HashSet<>());
            reporter.put(id, 0);
        }
        for (String r: report) {
            String[] split = r.split(" ");
            Set<String> set = map.get(split[1]);
            set.add(split[0]);
        }

        for (String id: id_list) {
            Set<String> set = map.get(id);
            if (set.size() >= k) {
                for (String s: set) {
                    reporter.put(s, reporter.get(s) + 1);
                }
            }
        }
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reporter.get(id_list[i]);
        }

        return answer;
    }
}

