package neetcode.Neetcode150.TwoPointers;

public class sol13 {
    public int maxArea(int[] heights) {
        int max = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int wide = j - i;
                int height = Math.min(heights[i], heights[j]);

                max = Math.max(max, wide * height);
            }
        }

        return max;
    }
}
