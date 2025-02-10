package neetcode.Neetcode150.ArraysHashing;

import java.util.*;

public class sol05 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int countAns = 0;

        for (int i = freq.length - 1; i >= 0 && countAns < k; i--) {
            for (Integer f: freq[i]) {
                result[countAns++] = f;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        topKFrequent(new int[] {1,2,2,3,3,3},2);
    }
}
