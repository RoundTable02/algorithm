package bojclass;

import java.io.*;
import java.util.*;

public class Main3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N / 2]; // 석순
        int[] arr2 = new int[N / 2]; // 종유석
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (i % 2 == 0) arr1[i / 2] = now;
            else arr2[i / 2] = now;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int size = arr1.length;
        int min = 200001;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            int count1 = size - lowerBound(arr1, i);
            int count2 = size - lowerBound(arr2, H - i + 1);

            int destroy = count1 + count2;
            if (min > destroy) {
                min = destroy;
                count = 1;
            }
            else if (min == destroy) count++;
        }

        System.out.println(min + " " + count);
    }

    static int lowerBound(int[] arr, int target) {
        int min = 0; int max = arr.length;
        while (min < max) {
            int mid = (min + max) / 2;
            if (arr[mid] < target) min = mid + 1;
            else max = mid;
        }

        return min;
    }
}

