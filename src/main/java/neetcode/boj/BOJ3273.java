package neetcode.boj;

import java.util.*;
import java.io.*;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        int target = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(target - arr[i])) {
                count++;
            }
        }

        System.out.println(count / 2);
    }
}
