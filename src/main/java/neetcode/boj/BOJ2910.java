package neetcode.boj;

// 첫째 줄에 메시지의 길이 N과 C가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ C ≤ 1,000,000,000)
// 둘째 줄에 메시지 수열이 주어진다.

import java.io.*;
import java.util.*;

public class BOJ2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        // 등장 순서와 빈도 저장
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 빈도 내림차순, 등장 순서 유지
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : list) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            for (int i = 0; i < cnt; i++) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);
    }
}
