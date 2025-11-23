package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int left = 0; int right = N - 1;
            int target = arr[i];
            while (left < right) {
                if (left == i) { left++; continue; }
                if (right == i) { right--; continue; }

                int hap = arr[left] + arr[right];
                if (hap > target) {
                    right--;
                }
                else if (hap < target) {
                    left++;
                }
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}


