package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {
    /**
     * Binary Search - guess number
     *
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int st = 1;
        int end = nums.length - 1;
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            int count = countSmallerThan(nums, pl);
            if (count > pl) {
                end = pl;
            } else {
                st = pl;
            }
        }
        if (countSmallerThan(nums, st) > st) {
            return st;
        }
        return end;
    }

    private int countSmallerThan(int[] nums, int pl) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= pl) {
                count++;
            }
        }
        return count;
    }
}
