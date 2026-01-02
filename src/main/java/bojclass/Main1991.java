package bojclass;

import java.io.*;
import java.util.*;

public class Main1991 {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = (int) st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            int leftValue = (left != '.') ? (int) left - 'A' : -1;
            int rightValue = (right != '.') ? (int) right - 'A' : -1;
            arr[start][LEFT] = leftValue;
            arr[start][RIGHT] = rightValue;
        }

        StringBuilder sb = new StringBuilder();
        first_traverse(0, sb);
        sb.append("\n");
        mid_traverse(0, sb);
        sb.append("\n");
        last_traverse(0, sb);

        System.out.println(sb);
    }

    static void first_traverse(int start, StringBuilder sb) {
        sb.append((char) (start + 'A'));
        if(arr[start][LEFT] != -1) {
            first_traverse(arr[start][LEFT], sb);
        }
        if(arr[start][RIGHT] != -1) {
            first_traverse(arr[start][RIGHT], sb);
        }
    }

    static void mid_traverse(int start, StringBuilder sb) {
        if(arr[start][LEFT] != -1) {
            mid_traverse(arr[start][LEFT], sb);
        }
        sb.append((char) (start + 'A'));
        if(arr[start][RIGHT] != -1) {
            mid_traverse(arr[start][RIGHT], sb);
        }
    }

    static void last_traverse(int start, StringBuilder sb) {
        if(arr[start][LEFT] != -1) {
            last_traverse(arr[start][LEFT], sb);
        }
        if(arr[start][RIGHT] != -1) {
            last_traverse(arr[start][RIGHT], sb);
        }
        sb.append((char) (start + 'A'));
    }
}