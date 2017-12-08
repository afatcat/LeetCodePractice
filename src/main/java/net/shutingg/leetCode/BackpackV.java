package net.shutingg.leetCode;

public class BackpackV {
    /*
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[][] f = new int[target+1][n+1];
        f[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                f[j][i] = f[j][i-1];
                if(j >= nums[i-1]){
                    f[j][i] += f[j - nums[i-1]][i-1];
                }
            }
        }

        return f[target][n];
    }
}
