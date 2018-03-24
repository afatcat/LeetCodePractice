package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/
 */
public class MaximumNumberInMountainSequence {
    /**
     * Binary Search
     *
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int st = 0;
        int end = nums.length - 1;
        while (st + 2 < end) {
            int pl = (end - st) / 2 + st;
            if (nums[pl] > nums[pl - 1] && nums[pl] > nums[pl + 1]) {
                return nums[pl];
            } else if (nums[pl] > nums[pl - 1]) {
                st = pl;
            } else {
                end = pl;
            }
        }

        if (st == end) {
            return nums[st];
        }

        if (st + 1 == end) {
            if (nums[st] < nums[end]) {
                return nums[end];
            } else {
                return nums[st];
            }
        }

        if (nums[st] > nums[st + 1]) {
            return nums[st];
        }
        if (nums[end] > nums[end - 1]) {
            return nums[end];
        }
        return nums[(end - st) / 2 + st];
    }
}
