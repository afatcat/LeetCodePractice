package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/digital-flip/
 */
public class DigitalFlip {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] f = new int[n + 1][2];
        f[0][0] = 0;
        f[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            f[i][0] = Math.min(f[i - 1][0] + nums[i - 1], f[i - 1][1] + nums[i - 1]);
            f[i][1] = f[i - 1][1] + (1 - nums[i - 1]);
        }

        return Math.min(f[n][0], f[n][1]);
    }
}
