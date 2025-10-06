package gdgoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gdgoc2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N + k - 1];
        int[] window = new int[d + 1];
        window[c] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sushi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i < N + k - 1; i++) {
            sushi[i] = sushi[i - N];
        }

        int nowCount = 1;
        for (int i = 0; i < k; i++) {
            if (window[sushi[i]] == 0) {
                nowCount++;
            }
            window[sushi[i]]++;
        }

        int maxCount = nowCount;

        for (int i = k; i < N + k - 1; i++) {
            if (maxCount == k + 1) {
                System.out.println(maxCount);
                return;
            }
            if (window[sushi[i - k]] == 1) {
                nowCount--;
            }
            window[sushi[i - k]]--;

            if (window[sushi[i]] == 0) {
                nowCount++;
            }
            window[sushi[i]]++;

            maxCount = Math.max(maxCount, nowCount);
        }

        System.out.println(maxCount);
    }
}
