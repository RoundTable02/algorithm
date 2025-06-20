package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ10816 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int left = findLeft(0, n - 1, target);
            int right = findRight(0, n - 1, target);
            if (left == -1 || right == -1) {
                sb.append("0 ");
            } else {
                sb.append(right - left + 1).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    private static int findLeft(int left, int right, int target) {
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else if (arr[mid] == target) {
                if (mid - 1 == -1 || arr[mid - 1] != target) {
                    result = mid;
                    break;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int findRight(int left, int right, int target) {
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else if (arr[mid] == target) {
                if (mid + 1 == n || arr[mid + 1] != target) {
                    result = mid;
                    break;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }
}