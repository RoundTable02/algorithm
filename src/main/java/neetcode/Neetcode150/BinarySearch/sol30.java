package neetcode.Neetcode150.BinarySearch;

import java.util.Arrays;

public class sol30 {
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        Arrays.sort(piles);
        int i = 1, j = piles[n - 1];

        int min = 0;
        while (i <= j) {
            int time = 0;
            int m = (i + j) / 2;
            for (int k = n - 1; k >= 0; k--) {
                if (time > h)
                    break;

                time += Math.ceil((double) piles[k] / m);
            }

            if (time > h) {
                i = m + 1;
            } else {
                min = m;
                j = m - 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        minEatingSpeed(new int[]{25, 10, 23, 4}, 4);
    }
}
