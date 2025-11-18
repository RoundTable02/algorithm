package gdgoc;

// 각 숫자를 이진수로 변환
// N까지 모든 숫자를 하나씩 돌면서 각 숫자와 XOR, bitCount로 숫자 세기
// 숫자가 P 이하면 count++

import java.io.*;
import java.util.*;

public class gdgoc22251 {

    static int[] binary = new int[] {
            0b1110111,
            0b0010010,
            0b1011101,
            0b1011011,
            0b0111010,
            0b1101011,
            0b1101111,
            0b1010010,
            0b1111111,
            0b1111011
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 층 수
        int K = Integer.parseInt(st.nextToken()); // 자릿수
        int P = Integer.parseInt(st.nextToken()); // 반전 대상
        int X = Integer.parseInt(st.nextToken()); // 현재 층

        // 현재 층을 자리수 별로 쪼개기
        int[] now = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            int num = X % 10;
            now[i] = binary[num];
            X /= 10;
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            int target = i;
            for (int j = K - 1; j >= 0; j--) {
                int num = target % 10;
                count += Integer.bitCount(binary[num] ^ now[j]);
                target /= 10;
            }

            if (count >= 1 && count <= P) result++;
        }

        System.out.println(result);
    }
}
