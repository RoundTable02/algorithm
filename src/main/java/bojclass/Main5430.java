package bojclass;

import java.io.*;
import java.util.*;

public class Main5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String raw = br.readLine().replace("[", "").replace("]", "");
            StringTokenizer st = new StringTokenizer(raw, ",");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Calc calc = new Calc(arr);

            for (char c: func.toCharArray()) {
                if (c == 'R') {
                    calc.reverse();
                }
                else {
                    calc.delete();
                }
            }
            System.out.println(calc.getAll());
        }
    }

    static class Calc {
        int[] arr;
        boolean isReversed = false;
        boolean hasError = false;
        int left = 0;
        int right;

        Calc(int[] arr) {
            this.arr = arr;
            this.right = arr.length;
        }

        void reverse() {
            isReversed = !isReversed;
        }

        void delete() {
            if (right == left) {
                hasError = true;
            }

            if (isReversed) right--;
            else left++;
        }

        String getAll() {
            if (hasError) {
                return "error";
            }
            if (left == right) {
                return "[]";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (isReversed) {
                for (int i = right - 1; i >= left; i--) {
                    sb.append(arr[i]).append(",");
                }
            }
            else {
                for (int i = left; i < right; i++) {
                    sb.append(arr[i]).append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");

            return sb.toString();
        }
    }
}
