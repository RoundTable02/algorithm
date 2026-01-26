package programmers;

import java.util.*;

class Solution92341 {
    int standardTime;
    int standardFee;
    int unitTime;
    int unitFee;

    public int[] solution(int[] fees, String[] records) {
        standardTime = fees[0];
        standardFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        Map<String, Integer> ins = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        for (String record: records) {
            String[] arr = record.split(" ");
            int minutes = toMinutes(arr[0]);
            if (arr[2].equals("IN")) ins.put(arr[1], minutes);
            else {
                int total = minutes - ins.get(arr[1]);
                map.put(arr[1], map.getOrDefault(arr[1], 0) + total);
                ins.remove(arr[1]);
            }
        }

        int lastTime = toMinutes("23:59");

        for (String key: ins.keySet()) {
            int total = lastTime - ins.get(key);
            map.put(key, map.getOrDefault(key, 0) + total);
        }

        int[][] arr = new int[map.size()][2];
        int i = 0;
        for (String key: map.keySet()) {
            arr[i][0] = Integer.parseInt(key);
            arr[i][1] = settle(map.get(key));
            i++;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int[] answer = new int[map.size()];
        for (i = 0; i < map.size(); i++) answer[i] = arr[i][1];

        return answer;
    }

    int toMinutes(String timestamp) {
        String[] times = timestamp.split(":");
        int hours = Integer.parseInt(times[0]) * 60;
        int minutes = Integer.parseInt(times[1]);

        return hours + minutes;
    }

    int settle(int total) {
        int money = 0;
        if (total < standardTime) return standardFee;

        total -= standardTime;
        int unit = (total + unitTime - 1) / unitTime;
        money = standardFee + unit * unitFee;

        return money;
    }
}
