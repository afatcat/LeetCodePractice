package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/burst-balloons/
 */
public class BurstBalloons {
    /**
     * DP - section
     *
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;

        int[][] f = new int[n+2][n+2];
        for(int len = 3; len <= n+2; len++){
            for(int j=0; j <= n + 2 - len; j++){
                int left = 1;
                if(j != 0){
                    left = nums[j-1];
                }
                int right = 1;
                int k = j + len -1;
                if(k != n+1){
                    right = nums[k-1];
                }
                f[j][k] = 0;

                for(int i=j+1; i < k; i++){
                    f[j][k] = Math.max(f[j][k], f[j][i]+f[i][k]+left*nums[i-1]*right);
                }
            }
        }

        return f[0][n+1];
    }
}
