package neetcode.boj;

import java.io.*;
import java.util.*;


// 루트 노드부터 탐색 시작 -> 노드 리스트에 이전 노드를 부모 노드로 추가
public class BOJ11725 {
    static int[] parent;
    static List<Integer>[] list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        dfs(1,1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int before, int now) {
        List<Integer> nextList = list[now];
        for (int next : nextList) {
            if (before != next) {
                parent[next] = now;
                dfs(now, next);
            }
        }
    }
}