package gdgoc;

import java.io.*;

public class gdgoc2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int kbs1 = 0;
        int kbs2 = 0;
        for (int i = 0; i < num; i++) {
            String channel = br.readLine();
            if (channel.equals("KBS1")) kbs1 = i;
            if (channel.equals("KBS2")) kbs2 = i;
        }

        if (kbs1 > kbs2) {
            kbs2++;
        }
        String answer = "1".repeat(kbs1) +
                "4".repeat(kbs1) +
                "1".repeat(kbs2) +
                "4".repeat(kbs2 - 1);

        System.out.println(answer);
    }
}
