package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/paint-house-ii/
 */
public class PaintHouseII {
    /**
     * DP - sequence
     *
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        //f[i][j] = min(f[i - 1][0], ..., f[i - 1][j - 1], f[i -1][j + 1], ...) + costs[i][j]
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int m = costs[0].length;
        int[][] f = new int[n][m];
        for (int j = 0; j < m; j++) {
            f[0][j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (k == j) {
                        continue;
                    }
                    f[i][j] = Math.min(f[i][j], f[i - 1][k]);
                }
                f[i][j] += costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, f[n - 1][j]);
        }

        return min;
    }
}
