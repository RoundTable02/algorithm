package neetcode.boj;

import java.util.*;

// 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
// 둘째 줄에는 중앙값을 출력한다.
// 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
// 넷째 줄에는 범위를 출력한다.

public class BOJ2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        int freq = 0;

        Map<Integer, Integer> map = new HashMap<>(); // number, frequency
        List<Integer> mostFrequentList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int now = sc.nextInt();
            list.add(now);

            sum += now;

            map.put(now, map.getOrDefault(now, 0) + 1);

            int nowCount = map.get(now);
            if (nowCount == freq) {
                mostFrequentList.add(now);
            }
            else if (nowCount > freq) {
                mostFrequentList.clear();
                mostFrequentList.add(now);

                freq++;
            }
        }

        Collections.sort(mostFrequentList);

        Collections.sort(list);

        // 산술평균
        System.out.println(Math.round((double) sum / n));

        // 중앙값
        if (n % 2 == 0) {
            System.out.println((list.get(n / 2 - 1) + list.get(n / 2))/2);
        }
        else {
            System.out.println(list.get(n / 2));
        }

        // 최빈값
        if(mostFrequentList.size() >= 2) {
            System.out.println(mostFrequentList.get(1));
        }
        else {
            System.out.println(mostFrequentList.get(0));
        }

        // 범위
        System.out.println(list.get(list.size() - 1) - list.get(0));



    }
}
