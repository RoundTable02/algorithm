package neetcode.boj;

import java.util.*;

public class BOJ1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        int nowCount = 0;
        queue.offer(new int[]{nowCount, n});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            nowCount = now[0];
            int nowNum = now[1];

            if (nowNum == 1) {
                break;
            }
            else {
                nowCount++;
                if (nowNum % 3 == 0 && !visited.contains(nowNum % 3)) {
                    queue.offer(new int[]{nowCount, nowNum / 3});
                }
                if (nowNum % 2 == 0 && !visited.contains(nowNum % 2)) {
                    queue.offer(new int[]{nowCount, nowNum / 2});
                }
                if (!visited.contains(nowNum - 1)) {
                    queue.offer(new int[]{nowCount, nowNum - 1});
                }
            }
        }

        System.out.println(nowCount);
    }
}
