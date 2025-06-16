package neetcode.boj;

// 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
// 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

import java.util.*;

public class BOJ13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] time = new int[100001];
        Arrays.fill(time, -1);
        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(n);
        time[n] = 0;

        while(!queue.isEmpty()) {
            int now = queue.pollFirst();
            if (now == k) {
                break;
            }
            else {
                if (now - 1 >= 0 && (time[now - 1] == -1 || time[now - 1] > time[now] + 1)) {
                    time[now - 1] = time[now] + 1;
                    queue.offerLast(now - 1);
                }
                if (now + 1 <= 100000 && (time[now + 1] == -1 || time[now + 1] > time[now] + 1)) {
                    time[now + 1] = time[now] + 1;
                    queue.offerLast(now + 1);
                }
                if (now * 2 <= 100000 && (time[now * 2] == -1 || time[now * 2] > time[now])) {
                    time[now * 2] = time[now];
                    queue.offerLast(now * 2);
                }
            }
        }

        System.out.println(time[k]);
    }
}
