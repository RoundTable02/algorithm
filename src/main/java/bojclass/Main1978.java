package bojclass;

import java.io.*;
import java.util.*;

public class Main1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        while (N-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            boolean isPrime = true;
            for (int i = 2; i * i <= target; i++) {
                if (target % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (target != 1 && isPrime) result++;
        }

        System.out.println(result);
    }
}