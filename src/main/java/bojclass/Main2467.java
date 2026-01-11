package bojclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = N - 1;
        int best = Integer.MAX_VALUE;
        int ansL = 0; int ansR = 0;

        while (left < right) {
            int hap = arr[left] + arr[right];
            if (best > Math.abs(hap)) {
                best = Math.abs(hap);
                ansL = arr[left];
                ansR = arr[right];
            }

            if (hap > 0) {
                right--;
            }
            else {
                left++;
            }
        }

        System.out.println(ansL + " " + ansR);
    }
}
