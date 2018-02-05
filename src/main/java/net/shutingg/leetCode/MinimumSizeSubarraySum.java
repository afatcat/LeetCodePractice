package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    /**
     * Window Pointers
     * O(n)
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize2(int[] nums, int s) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int sum = 0;
        int j = 0;
        int result = n + 1;
        for (int i = 0; i < n; i++) {
            while (sum < s && j < n) {
                sum += nums[j];
                j++;
            }
            if(sum >= s) {
                result = Math.min(result, j - i);
            }
            sum = sum - nums[i];
        }
        if (result == n + 1) {
            return -1;
        }
        return result;
    }

    /**
     * DP + rolling array
     * O(n^2)
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] f = new int[n];
        for (int l = 0; l < n; l++) {
            for (int i = n - l -1; i >= 0; i--) {
                if (l >= 1) {
                    f[i+l] = f[i+l-1] + nums[i+l];
                } else {
                    f[i] = nums[i];
                }
                if (f[i+l] >= s) {
                    return l + 1;
                }
            }
        }
        return -1;
    }
}
