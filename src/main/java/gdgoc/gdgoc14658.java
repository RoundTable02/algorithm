package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc14658 {
    static int N, M, L, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[] { x, y });
        }

        int max = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int startX = list.get(i)[0];
                int startY = list.get(j)[1];
                int count = 0;

                for (int[] now : list) {
                    if (isInside(startX, startY, now[0], now[1])) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }

        System.out.println(K - max);
    }

    public static boolean isInside(int startx, int starty, int x, int y) {
        return startx <= x && x <= startx + L && starty <= y && y <= starty + L;
    }
}
