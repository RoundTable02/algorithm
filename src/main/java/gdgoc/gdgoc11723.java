package gdgoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gdgoc11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        CustomSet cs = new CustomSet();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int target = 0;
            if (st.hasMoreTokens()) {
                target = Integer.parseInt(st.nextToken());
            }
            switch (command) {
                case "add":
                    cs.add(target);
                    break;
                case "remove":
                    cs.remove(target);
                    break;
                case "check":
                    sb.append(cs.check(target)).append('\n');
                    break;
                case "toggle":
                    cs.toggle(target);
                    break;
                case "all":
                    cs.all();
                    break;
                case "empty":
                    cs.empty();
                    break;
            }
        }

        System.out.println(sb);
    }

    static class CustomSet {
        private int[] arr = new int[21];

        public void add(int x) {
            arr[x] = 1;
        }

        public void remove(int x) {
            arr[x] = 0;
        }

        public int check(int x) {
            return arr[x];
        }

        public void toggle(int x) {
            if (check(x) == 0) {
                add(x);
            }
            else {
                remove(x);
            }
        }

        public void all() {
            Arrays.fill(arr, 1);
        }

        public void empty() {
            Arrays.fill(arr, 0);
        }
    }
}
