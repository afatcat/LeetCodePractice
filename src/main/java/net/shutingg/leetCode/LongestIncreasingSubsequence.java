package net.shutingg.leetCode;

public class LongestIncreasingSubsequence {
    /*
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[][] f = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                f[i][j] = 1;
                if(j>1){
                    for(int k = j-1; k >=1; k--){
                        if(k>=1 && nums[j-1] > nums[k-1]){
                            f[i][j] = Math.max(f[i][k] + 1, f[i][j]);
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int i = 1; i <=n; i++){
            res = Math.max(f[n][i], res);
        }

        return res;
    }
}
