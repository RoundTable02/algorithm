package gdgoc;

import java.util.*;

public class gdgoc1446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            if (to > D) continue;
            if (map.containsKey(to)) {
                map.get(to).add(new int[]{from, weight});
            } else {
                List<int[]> arr = new ArrayList<>();
                arr.add(new int[]{from, weight});
                map.put(to, arr);
            }
        }

        int[] result = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            result[i] = i;
        }

        for (int i = 1; i <= D; i++) {
            result[i] = Math.min(result[i], result[i - 1] + 1);
            if (map.containsKey(i)) {
                List<int[]> arr = map.get(i);
                for (int[] value : arr) {
                    result[i] = Math.min(result[i], result[value[0]] + value[1]);
                }
            }
        }
        System.out.println(result[D]);
    }
}
