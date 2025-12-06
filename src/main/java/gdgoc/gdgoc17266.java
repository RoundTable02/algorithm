package gdgoc;

import java.io.*;
import java.util.*;

// 최소한의 길이 == 현재 위치 - 이전 위치
// 최초 높이 == 첫 번째 x값

public class gdgoc17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = 0;
        int last = 0;

        int cur = Integer.parseInt(st.nextToken());
        h = cur;
        last = cur;
        M--;

        while (M-- > 0) {
            cur = Integer.parseInt(st.nextToken());
            if (cur - last > 2 * h) {
                int len = cur - last;
                len = (len % 2 == 1) ? len + 1: len;
                h = len / 2;
            }
            last = cur;
        }

        h = Math.max(h, N - last);

        System.out.println(h);
    }
}