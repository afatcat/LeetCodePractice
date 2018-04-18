package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/wiggle-subsequence/description/
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        int max = 0;
        for (int j = 0; j < n; j++) {
            up[j] = 1;
            down[j] = 1;
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    up[j] = Math.max(up[j], down[i] + 1);
                }
                if (nums[i] > nums[j]) {
                    down[j] = Math.max(down[j], up[i] + 1);
                }
            }
            max = Math.max(max, up[j]);
            max = Math.max(max, down[j]);
        }

        return max;
    }
}
