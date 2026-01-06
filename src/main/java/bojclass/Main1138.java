package bojclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int countZero = 0;
            for (int j = 1; j <= N; j++) {
                if (result[j] == 0) {
                    countZero++;
                }
                if (result[j] == 0 && countZero == num + 1) {
                    result[j] = i;
                    break;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
