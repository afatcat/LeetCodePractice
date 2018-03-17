package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/maximum-subarray-vi/
 *
 * Given an array of integers. find the maximum XOR subarray value in given array.

 What's the XOR: https://en.wikipedia.org/wiki/Exclusive_or

 Notice

 Expected time complexity O(n).

 Have you met this question in a real interview? Yes
 Example
 Given nums = [1, 2, 3, 4], return 7
 The subarray [3, 4] has maximum XOR value

 Given nums = [8, 1, 2, 12, 7, 6], return 15
 The subarray [1, 2, 12] has maximum XOR value

 Given nums = [4, 6], return 6
 The subarray [6] has maximum XOR value
 */
public class MaximumSubarrayVI {
    /**
     * DP - rolling array + interval
     *
     * @param nums: the array
     * @return: the max xor sum of the subarray in a given array
     */
    public int maxXorSubarray(int[] nums) {
        // f[i, j] = max(f[i, j - 1] xor a[j], f[i + 1, j] xor a[i])
        // f[i, i] = i

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = nums[i];
            if (f[i] > max) {
                max = f[i];
            }
        }

        for (int l = 1; l < n; l++) {
            for (int j = 0; j + l < n; j++) {
                f[j] = Math.max(f[j] ^ nums[j + l], f[j + 1] ^ nums[j]);
                if (f[j] > max) {
                    max = f[j];
                }
            }
        }

        return max;
    }
}
