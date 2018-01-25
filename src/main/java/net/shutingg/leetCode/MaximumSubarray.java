package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/maximum-subarray/
 */
public class MaximumSubarray {
    /**
     * Greedy
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int res = nums[0];
        int pre = nums[0] > 0 ? nums[0]:0;
        for(int i = 1; i < n; i++){
            if(pre + nums[i] > 0) {
                pre = pre + nums[i];
                res = Math.max(res, pre);
            } else {
                pre = 0;
            }
        }
        return res;
    }

    /**
     * DP - O(n^2)
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int[] f = new int[n];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            f[i] = nums[i];
            if(f[i] > res) {
                res = f[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0) {
                continue;
            }
            f[i] = nums[i];
            for(int j = i + 1; j < n; j++){
                f[j] = f[j-1] + nums[j];
                if(f[j] > res) {
                    res = f[j];
                }
            }
        }
        return res;
    }
}
