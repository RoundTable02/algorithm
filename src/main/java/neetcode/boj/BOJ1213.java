package neetcode.boj;

import java.io.*;

public class BOJ1213 {
    public static void main(String[] args) throws IOException {
        // "I'm Sorry Hansoo"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[50];

        int length = s.length();
        for(int i = 0; i < length; i++) {
            int index = s.charAt(i) - 'A';
            arr[index] += 1;
        }

        StringBuilder sb = new StringBuilder();
        boolean isOddNumberChecked = false;
        for(int i = 49; i >= 0; i--) {
            int now = arr[i];
            char c = (char) (i + (int) 'A');
            if(now != 0) {
                if(now % 2 == 1) {
                    if (isOddNumberChecked) {
                        sb.delete(0, sb.length());
                        sb.append("I'm Sorry Hansoo");
                        break;
                    }
                    // 홀수 개수
                    isOddNumberChecked = true;
                    arr[i] -= 1;
                    sb.insert(sb.length() / 2, c);
                    i++;
                }
                else {
                    // 짝수 개수
                    for (int j = 0; j < now / 2; j++) {
                        sb.insert(0, c);
                        sb.append(c);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
