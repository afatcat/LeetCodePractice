package net.shutingg.leetCode;

public class LongestIncreasingSubsequence {
    /**
     * DP - O(N^2)
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        //f[i] = 1 or min(f[j]+1 | nums[j-1]<nums[i-1])

        int n = nums.length;
        if(n == 0) return 0;
        int[] f = new int[n+1];
        int[] a = new int[n+1];
        f[0] = 0;
        a[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            f[i] = 1;
            for(int j = 1; j < i; j++){
                if(nums[j-1] < nums[i-1]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
