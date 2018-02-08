package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/stone-game/
 */
public class StoneGame {
    /**
     * DP - interval
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // f[i][j] = f[i][k] + f[k+1][j] + sum[i][j]

        if(A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int[][] f = new int[n][n];
        int[][] sum = new int[n][n];
        for(int i = 0; i < n; i++) {
            sum[i][i] = A[i];
        }
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                sum[i][j] = sum[i][j-1] + A[i+l];
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < i + l; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k+1][j] + sum[i][j]);
                }
            }
        }
        return f[0][n-1];
    }
}
