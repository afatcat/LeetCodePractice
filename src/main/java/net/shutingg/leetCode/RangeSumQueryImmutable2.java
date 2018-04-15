package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * Simple sum
 * O(n) init, O(1) query
 */
public class RangeSumQueryImmutable2 {
    private int[] sums;

    public RangeSumQueryImmutable2(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sums.length == 0) {
            return 0;
        }
        if (j >= sums.length) {
            j = sums.length;
        }
        if (i < 0) {
            i = 0;
        }
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}
