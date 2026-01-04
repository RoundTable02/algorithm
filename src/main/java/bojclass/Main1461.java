package bojclass;

import java.io.*;
import java.util.*;

public class Main1461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > 0) plus.add(x);
            else minus.add(-x); // 절댓값으로 저장
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        int total = 0;
        int maxDist = 0;

        if (!plus.isEmpty()) maxDist = Math.max(maxDist, plus.get(0));
        if (!minus.isEmpty()) maxDist = Math.max(maxDist, minus.get(0));

        for (int i = 0; i < plus.size(); i += M) {
            total += plus.get(i) * 2;
        }

        for (int i = 0; i < minus.size(); i += M) {
            total += minus.get(i) * 2;
        }

        total -= maxDist; // 가장 먼 거리 한 번만 편도

        System.out.println(total);
    }
}
