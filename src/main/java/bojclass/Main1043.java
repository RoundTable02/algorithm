package bojclass;

import java.io.*;
import java.util.*;

public class Main1043 {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 진실을 아는 사람 입력
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        int[] truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 정보 저장
        int[][] parties = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            parties[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 파티별로 사람들 union
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < parties[i].length; j++) {
                union(parties[i][0], parties[i][j]);
            }
        }

        // 진실을 아는 사람들의 root 수집
        Set<Integer> truthRoots = new HashSet<>();
        for (int p : truthPeople) {
            truthRoots.add(find(p));
        }

        // 거짓말 가능한 파티 수 계산
        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int p : parties[i]) {
                if (truthRoots.contains(find(p))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }
}
