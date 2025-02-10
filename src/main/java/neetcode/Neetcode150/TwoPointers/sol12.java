package neetcode.Neetcode150.TwoPointers;

import java.util.*;

public class sol12 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -1 * nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (target > nums[j] + nums[k]) {
                    j++;
                }
                else if (target < nums[j] + nums[k]) {
                    k--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    k--;
                }
            }
        }

       return result.stream().toList();
    }

    public static void main(String[] args) {
        threeSum(new int[] {-1,0,1,2,-1,-4});

    }
}
