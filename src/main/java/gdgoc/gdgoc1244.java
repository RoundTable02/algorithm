package gdgoc;

// 남자 -> 그냥 배수 다 toggle
// 여자 -> 폭 늘리면서 양쪽 같을 때만 toggle

import java.io.*;
import java.util.*;

public class gdgoc1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buttons = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            buttons[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isMan = Integer.parseInt(st.nextToken()) == 1;
            int num = Integer.parseInt(st.nextToken());
            buttons[num] = toggle(buttons[num]);

            if (isMan) {
                int target = num * 2;
                while (target <= N) {
                    buttons[target] = toggle(buttons[target]);
                    target += num;
                }
            }
            else {
                int left = num - 1; int right = num + 1;

                while (left > 0 && right < N + 1 && buttons[left] == buttons[right]) {
                    buttons[left] = toggle(buttons[left]);
                    buttons[right] = toggle(buttons[right]);
                    left--; right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(buttons[i]);
            if (i % 20 == 0) {
                sb.append("\n");
            }
            else {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    static int toggle(int cur) {
        return cur == 1 ? 0 : 1;
    }
}

