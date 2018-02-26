package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/unique-paths-ii/
 */
public class UniquePathsII {
    /**
     * DP - coordinate
     *
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // f[i][j] = f[i-1][j] + f[i][j-1] | obstacleGrid[i][j] = 0
        // OR f[i][j] = 0;
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] f = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        f[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            f[i][0] = f[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            f[0][j] = f[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                    continue;
                }
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
