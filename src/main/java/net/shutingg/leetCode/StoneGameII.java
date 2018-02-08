package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/stone-game-ii/
 */
public class StoneGameII {
    /**
     * DP - interval
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame2(int[] A) {
        // f[i][j] = min(f[i][k] + f[k+1][j] + sum[i][j])
        if (A == null || A.length==0) {
            return 0;
        }
        int n = A.length;
        int[][] f = new int[n][n];
        int[][] sum = new int[n][n];

        sum[0][0] = A[0];
        for (int i = 1; i < n; i++) {
            sum[i][i] = A[i];
            sum[0][i] = sum[0][i - 1] + A[i];
        }
        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l;
                if (j < n) {
                    sum[i][j] = sum[i][j-1] + A[j];
                    f[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k+1][j] + sum[i][j]);
                    }
                } else {
                    j = j - n;
                    sum[i][j] = sum[i][n-1] + sum[0][j];
                    f[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < n - 1; k++) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k+1][j] + sum[i][j]);
                    }
                    f[i][j] = Math.min(f[i][j], f[i][n-1] + f[0][j] + sum[i][j]);
                    for (int k = 0; k < j; k++) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k+1][j] + sum[i][j]);
                    }
                }
            }
        }

        int res = f[0][n-1];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, f[i][i - 1]);
        }
        return res;
    }
}
