package neetcode.boj;

import java.util.*;

public class BOJ1697 {
    static int TARGET;
    static int TRIAL = 0;
    static boolean isFound;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int now = sc.nextInt();
        TARGET = sc.nextInt();
        queue.offer(now);

        while(!isFound) {
            findSister();
        }

        System.out.println(TRIAL);
    }

    private static void findSister() {
        int nowCount = queue.size();

        for (int i = 0; i < nowCount; i++) {
            int now = queue.poll();
            if (now == TARGET) {
                isFound = true;
                return;
            }
            if (now + 1 <= 100000 && !visited[now + 1]) {
                queue.offer(now + 1);
                visited[now + 1] = true;
            }
            if (now - 1 >= 0 && !visited[now - 1]) {
                queue.offer(now - 1);
                visited[now - 1] = true;
            }
            if (now * 2 <= 100000 && !visited[now * 2]) {
                queue.offer(now * 2);
                visited[now * 2] = true;
            }
        }
        TRIAL++;
    }
}