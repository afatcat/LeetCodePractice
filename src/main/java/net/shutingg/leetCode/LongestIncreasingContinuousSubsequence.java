package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/longest-increasing-subsequence/
 */
public class LongestIncreasingContinuousSubsequence {
    /**
     * DP - coordinate
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // f[i] = f[i-1] + 1 | A[i] > A[i-1]
        // g[i] = 1
        //OR
        // g[i] = g[i-1] + 1 | A[i] > A[i-1]
        // f[i] = 1

        if(A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = 1;
        g[0] = 1;
        for(int i = 1; i < n; i++){
            if(A[i] > A[i-1]){
                f[i] = f[i-1] + 1;
                g[i] = 1;
                continue;
            }
            if(A[i] < A[i-1]){
                g[i] = g[i-1] + 1;
                f[i] = 1;
                continue;
            }
            f[i] = 1;
            g[i] = 1;
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, f[i]);
            res = Math.max(res, g[i]);
        }
        return res;
    }
}
