package bojclass;

import java.io.*;

public class Main4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            System.out.println(recursive(n));
        }
    }

    static String recursive(int n) {
        if (n == 0) return "-";
        int k = 1;
        for (int i = 0; i < n - 1; i++) {
            k *= 3;
        }
        return recursive(n - 1) + " ".repeat(k) + recursive(n - 1);
    }
}