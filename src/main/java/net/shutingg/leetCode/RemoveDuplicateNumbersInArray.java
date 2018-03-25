package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.lintcode.com/en/problem/remove-duplicate-numbers-in-array/
 */
public class RemoveDuplicateNumbersInArray {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while (j < nums.length) {
            if (!set.contains(nums[j])) {
                set.add(nums[j]);
                nums[i] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }
}
