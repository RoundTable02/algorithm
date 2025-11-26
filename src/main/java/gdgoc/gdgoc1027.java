package gdgoc;

// y증가/x증가 = 기울기
// 왼쪽) 가장 큰 놈이랑 target의 기울기 > cur과 target 사이 기울기
// 오른쪽) 가장 큰 놈이랑 target의 기울기 < cur과 target 사이 기울기

import java.io.*;
import java.util.*;

public class gdgoc1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            int target = arr[i];

            double leftMax = 0.0;
            double rightMin = 0.0;
            if (i > 0) {
                leftMax = (double)(target - arr[i-1]) / 1;
                count++;
            }
            if (i < N - 1) {
                rightMin = (double)(arr[i+1] - target) / 1;
                count++;
            }

            for (int j = i-2; j >= 0; j--) {
                double cur = (double) (target - arr[j]) / (i - j);
                if (cur < leftMax) {
                    count++;
                    leftMax = cur;
                }
            }

            for (int j = i+2; j < N; j++) {
                double cur = (double) (arr[j] - target) / (j - i);
                if (cur > rightMin) {
                    count++;
                    rightMin = cur;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
