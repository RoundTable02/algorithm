package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc1976 {
    static List<Integer>[] arr;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
            arr[i].add(i);
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 1) {
                    arr[i + 1].add(j + 1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] trip = new int[M];
        for (int i = 0; i < M; i++) {
            trip[i] = Integer.parseInt(st.nextToken());
        }

        int start = trip[0];
        for (int i = 1; i < M; i++) {
            if (!isConnected(start, trip[i])) {
                System.out.println("NO");
                return;
            }
            start = trip[i];
        }
        System.out.println("YES");
    }

    static boolean isConnected(int start, int end) {
        visited = new boolean[N + 1];
        return dfs(start, end);
    }

    static boolean dfs(int now, int target) {
        if (now == target) return true;
        visited[now] = true;

        for (int next : arr[now]) {
            if (!visited[next] && dfs(next, target)) {
                return true;
            }
        }
        return false;
    }
}
