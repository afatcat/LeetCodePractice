package net.shutingg.leetCode;

import java.util.List;

/**
 * http://www.lintcode.com/en/problem/minimum-adjustment-cost/
 */
public class MinimumAdjustmentCost {
    /**
     * DP
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // f[i][j] = min(f[i-1][j-target]+|A[i]-j|, ..., f[i-1][j+target]+|A[i]-j|)
        // f[0][j] = |A[0] - j|
        if(A == null){
            return 0;
        }
        int n = A.size();
        if(n==0){
            return 0;
        }
        int[][] f = new int[n][101];
        for(int i = 0; i <= 100; i++){
            f[0][i] = Math.abs(A.get(0) - i);
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= 100; j++){
                f[i][j] = Integer.MAX_VALUE;
                for(int k = j - target; k <= j+target; k++){
                    if(k >=0 && k <=100){
                        f[i][j] = Math.min(f[i][j], f[i-1][k] + Math.abs(A.get(i)-j));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j = 0; j <= 100; j++){
            res = Math.min(res, f[n-1][j]);
        }
        return res;
    }
}
