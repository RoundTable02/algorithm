package bojclass;

import java.io.*;
import java.util.*;

public class Main2606 {
    static List<Integer>[] list;
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        list = new List[computers + 1];

        for (int i = 1; i < computers + 1; i++) {
            list[i] = new ArrayList<>();
        }

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        visited = new boolean[computers + 1];

        visit(1);

        System.out.println(result - 1);
    }

    static void visit(int idx) {
        result++;
        visited[idx] = true;

        List<Integer> nexts = list[idx];
        for (int next: nexts) {
            if (!visited[next]) {
                visit(next);
            }
        }
    }
}