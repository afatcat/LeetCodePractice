package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/two-sum-input-array-is-sorted/
 */
public class TwoSumInputArrayIsSorted {
    /**
     * Hash
     *
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index1 = map.get(target - nums[i]);
                return new int[]{index1 + 1, i + 1};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
