package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc1205 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 리스트가 꽉 찼고, 새로운 점수가 가장 낮은 점수 이하라면 못 들어감
        if (N == P && arr[N - 1] >= X) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] > X) {
                rank++;
            } else {
                break;
            }
        }

        System.out.println(rank);
    }
}

