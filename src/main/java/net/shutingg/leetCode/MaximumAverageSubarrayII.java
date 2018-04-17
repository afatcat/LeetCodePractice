package net.shutingg.leetCode;

public class MaximumAverageSubarrayII {
    /**
     * Binary Search - Guess Answer
     * https://leetcode.com/problems/maximum-average-subarray-ii/solution/
     *
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage2(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }

        double l = -1e10;
        double r = 1e10;
        double delta = 1e-6;
        while (l + delta < r) {
            double mid = (r - l) / 2 + l;
            if (hasAvgGreaterThan(nums, k, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }

    boolean hasAvgGreaterThan(int[] nums, int k, double guess) {
        double deltaSum = 0;
        for (int i = 0; i < k; i++) {
            deltaSum = deltaSum + nums[i] - guess;
        }
        if (deltaSum >= 0) {
            return true;
        }
        double preSum = 0;
        double minSum = 0;
        for (int i = k; i < nums.length; i++) {
            deltaSum += nums[i] - guess;
            preSum += nums[i - k] - guess;
            minSum = Math.min(preSum, minSum);
            if (deltaSum >= minSum) {
                return true;
            }
        }
        return false;
    }



    /**
     * DP + rolling array - O(n^2)
     * Timeout
     *
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        //f[i][j] = f[i][j - 1] + nums[j]
        //avg[i][j] = f[i][j] / (j - i + 1)
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }

        int n = nums.length;
        long[] f = new long[n];
        double maxAvg = -Double.MAX_VALUE;
        for (int i = 0; n - i >= k; i++) {
            f[i] = nums[i];
            if (k == 1 && f[i] > maxAvg) {
                maxAvg = f[i];
            }
            for (int j = i + 1; j < n; j++) {
                f[j] = f[j - 1] + nums[j];
                if (j - i + 1 >= k) {
                    double avg = f[j] / (j - i + 1.0);
                    if (avg > maxAvg) {
                        maxAvg = avg;
                    }
                }
            }
        }

        return maxAvg;
    }
}
