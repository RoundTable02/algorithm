package neetcode.Neetcode150.BinarySearch;

public class sol32 {
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int m = (i + j) / 2;

            if (target == nums[m])
                return m;

            if (nums[i] <= nums[m]) {
                if (target < nums[i] || target > nums[m]) {
                    i = m + 1;
                }
                else {
                    j = m - 1;
                }
            }
            else {
                if (target < nums[m] || target > nums[j]) {
                    j = m - 1;
                }
                else {
                    i = m + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }
}
