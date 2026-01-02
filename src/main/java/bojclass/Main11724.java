package bojclass;

import java.io.*;
import java.util.*;

public class Main11724 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        for (int i = 1; i < N + 1; i++) {
            setUp(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int a: arr) {
            set.add(a);
        }
        set.remove(0);

        System.out.println(set.size());
    }

    static void union(int a, int b) {
        int a_root = find(a);
        int b_root = find(b);

        if (a_root != b_root) {
            arr[b_root] = a_root;
        }
    }

    static int find(int a) {
        if (arr[a] == a) {
            return a;
        }

        return find(arr[a]);
    }

    static int setUp(int a) {
        if (arr[a] == a) {
            return a;
        }

        return arr[a] = setUp(arr[a]);
    }
}
