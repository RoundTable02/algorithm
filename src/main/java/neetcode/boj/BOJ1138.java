package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for(int i = n; i > 0; i--) {
            list.add(arr[i], i);
        }

        String result = "";
        for(int i = 0; i < n; i++) {
            result += list.get(i) + " ";
        }

        System.out.println(result);

    }
}
