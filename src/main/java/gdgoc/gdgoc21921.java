package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int[] history = new int[N];
        for (int i = 0; i < X; i++) {
            int now = Integer.parseInt(st.nextToken());
            history[i] = now;
            max += now;
        }

        int hap = max;
        int maxCount = 1;
        for (int i = X; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            history[i] = now;
            hap -= history[i - X];
            hap += now;
            if (max == hap) {
                maxCount++;
            }
            else if (max < hap) {
                max = hap;
                maxCount = 1;
            }
        }

        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max + "\n" + maxCount);
        }
    }
}
