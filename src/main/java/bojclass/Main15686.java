package bojclass;

import java.util.*;
import java.io.*;

public class Main15686 {
    // 집을 기준으로 각각의 치킨집까지의 거리 구하기
    // 치킨집 중 M개 골라서 각각의 거리 합을 정렬
    static List<int[]> targets = new ArrayList<>();
    static List<Node> houses = new ArrayList<>();
    static List<Node> chickens = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 집, 치킨집 위치 세팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) {
                    houses.add(new Node(i, j));
                }
                else if (now == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        int[][] dist = new int[houses.size()][chickens.size()];

        for (int i = 0; i < houses.size(); i++) {
            for (int j = 0; j < chickens.size(); j++) {
                dist[i][j] = houses.get(i).dist(chickens.get(j));
            }
        }

        for (int i = 0; i < chickens.size(); i++) {
            int[] arr = new int[M];
            Arrays.fill(arr, -1);
            arr[0] = i;
            backtrack(i, 1, arr);
        }

        int min = 10000;
        for (int[] target: targets) {
            int curDist = 0;
            for (int i = 0; i < houses.size(); i++) {
                int shortest = 100;
                for (int chicken: target) {
                    shortest = Math.min(shortest, dist[i][chicken]);
                }
                curDist += shortest;
            }
            min = Math.min(min, curDist);
        }

        System.out.println(min);
    }

    static class Node {
        int r; int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int dist(Node other) {
            return Math.abs(this.r - other.r) + Math.abs(this.c - other.c);
        }
    }

    // 백트래킹으로 M개 선택
    static void backtrack(int start, int depth, int[] arr) {
        if (depth == M) {
            targets.add(arr);
            return;
        }

        for (int i = start + 1; i < chickens.size(); i++) {
            arr[depth] = i;
            backtrack(i, depth + 1, arr.clone());
        }
    }
}