package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] walls = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            walls[i] = Integer.parseInt(st.nextToken());
        }

        int rain = 0;

        for (int i = 1; i < W - 1; i++) {
            int now = walls[i];
            int left = now;
            int right = now;

            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(walls[j], left);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(walls[j], right);
            }

            if (Math.min(left, right) > now) {
                rain += Math.min(left, right) - now;
            }
        }

        System.out.println(rain);

    }
}