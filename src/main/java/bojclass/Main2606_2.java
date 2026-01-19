package bojclass;

import java.io.*;
import java.util.*;

public class Main2606_2 {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        dfs(1);

        System.out.println(count - 1);
    }

    static void dfs(int now) {
        count++;
        visited[now] = true;
        for (int next: list[now]) {
            if (!visited[next]) dfs(next);
        }
    }
}

