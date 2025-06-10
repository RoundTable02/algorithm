package neetcode.boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = new int[m];
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int biggest = 0;
        for (int i = 1; i * i <= n * m; i++) {
            for (int j = 0; j + i <= n; j++) {
                for (int k = 0; k + i <= m; k++) {
                    int now = map[j][k];
                    if(now == map[j + i - 1][k]
                            && now == map[j][k + i - 1]
                            && now == map[j + i - 1][k + i - 1]) {
                        biggest = i * i;
                    }
                }
            }
        }

        System.out.println(biggest);
    }
}
