package neetcode.Neetcode150.ArraysHashing;

import java.util.*;

public class sol09 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int length = 1;
                while (set.contains(i + length)) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }

        return max;
    }
}
