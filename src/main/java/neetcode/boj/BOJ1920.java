package neetcode.boj;

import java.util.*;
import java.io.*;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < t; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
