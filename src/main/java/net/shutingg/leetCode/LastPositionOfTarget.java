package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/last-position-of-target/
 */
public class LastPositionOfTarget {
    /**
     * Binary Search
     *
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int st = 0;
        int end = nums.length - 1;
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            if (nums[pl] > target) {
                end = pl - 1;
            } else {
                st = pl;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[st] == target) {
            return st;
        }
        return -1;
    }
}
