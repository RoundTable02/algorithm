package neetcode.Neetcode150.BinarySearch;

public class sol28 {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int now = (i + j) / 2;

            if (nums[now] > target) {
                j = now - 1;
            } else if (nums[now] < target) {
                i = now + 1;
            }
            else {
                return now;
            }
        }

        return -1;
    }
}
