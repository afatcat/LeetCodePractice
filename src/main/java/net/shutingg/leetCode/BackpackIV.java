package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/backpack-iv/
 *
 * Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

 Each item may be chosen unlimited number of times

 Example
 Given candidate items [2,3,6,7] and target 7,

 A solution set is:
 [7]
 [2, 2, 3]
 return 2
 */
public class BackpackIV {
    /**
     * DP - backpack with unlimited items and limited size
     *
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackIV(int[] nums, int target) {
        //f[i][j] = f[i - 1][j] + ... + f[i - 1][j - k * nums[i - 1]]

        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }

        int n = nums.length;
        int[][] f = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    continue;
                }
                f[i][j] = f[i - 1][j];
                int k = 1;
                while (j - k * nums[i - 1] >= 0) {
                    f[i][j] += f[i - 1][j - k * nums[i - 1]];
                    k++;
                }
            }
        }

        return f[n][target];
    }
}
