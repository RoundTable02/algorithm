package neetcode.boj;
import java.util.*;
import java.io.*;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = n + 1;
        int sum = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            sum += arr[j];
            j++;

            while (sum >= s) {
                count = Math.min(count, j - i);
                sum -= arr[i];
                i++;
            }
        }

        if (count == n + 1) count = 0;

        System.out.println(count);
    }
}

