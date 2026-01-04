package bojclass;

import java.io.*;

public class Main5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price;

        int[] units = new int[] {500, 100, 50, 10, 5, 1};

        int result = 0;
        for (int unit: units) {
            if (change < unit) continue;
            int n = change / unit;
            change -= n * unit;
            result += n;
            if (change == 0) break;
        }

        System.out.println(result);
    }
}
