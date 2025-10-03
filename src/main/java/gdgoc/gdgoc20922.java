package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] line = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int best = 1;
        int i = 0, j = 1;
        map.put(line[0], 1);
        while (j < N) {
            int newNum = line[j];
            int beforeCount = map.getOrDefault(newNum, 0);
            if (beforeCount + 1 > K) {
                while (line[i] != newNum) {
                    map.put(line[i], map.get(line[i]) - 1);
                    i++;
                }
                i++;
            } else {
                map.put(newNum, beforeCount + 1);
                best = Math.max(best, j - i + 1);
            }
            j++;
        }

        System.out.println(best);
    }
}
