package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/maximum-average-subarray-i/
 */
public class MaximumAverageSubarrayI {
    /**
     * Sliding window
     *
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = sum / k;
        for (int i = 1; i <= n - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            max = Math.max(max, sum / k);
        }

        return max;
    }
}
