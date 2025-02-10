package neetcode.Neetcode150.TwoPointers;

public class sol14 {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;

        int leftMax = height[i];
        int rightMax = height[j];

        while (i < j) {
            if (leftMax < rightMax) {
                i++;
                leftMax = Math.max(leftMax, height[i]);
                result += leftMax - height[i];
            }
            else {
                j--;
                rightMax = Math.max(rightMax, height[j]);
                result += rightMax - height[j];
            }
        }
        return result;
    }
}
