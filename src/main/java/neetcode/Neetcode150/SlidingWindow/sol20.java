package neetcode.Neetcode150.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class sol20 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while (r < n) {
            while (!q.isEmpty() && nums[q.getLast()] > nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if (r + 1 >= k) {
                output[l] = q.getFirst();
                l++;
            }
            r++;
        }

        return output;
    }
}
