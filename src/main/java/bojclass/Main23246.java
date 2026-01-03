package bojclass;

import java.io.*;
import java.util.*;

public class Main23246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] person = new int[4];
            person[0] = Integer.parseInt(st.nextToken()); // 등번호
            person[1] = Integer.parseInt(st.nextToken());
            person[2] = Integer.parseInt(st.nextToken());
            person[3] = Integer.parseInt(st.nextToken());
            arr[i] = person;
        }
        Arrays.sort(arr, (p1, p2) -> {
            long score1 = (long) p1[1] * p1[2] * p1[3];
            long score2 = (long) p2[1] * p2[2] * p2[3];
            if(score1 == score2) {
                return (p1[1] + p1[2] + p1[3]) - (p2[1] + p2[2] + p2[3]);
            }
            return Long.compare(score1, score2);
        });
        System.out.println(arr[0][0] + " " + arr[1][0] + " " + arr[2][0]);
    }
}
