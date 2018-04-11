package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/bomb-enemy/
 */
public class BombEnemy {
    /**
     * DP - Coordinate
     *
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        //up[i][j] = 0 | grid[i][j] == 'W'
        //up[i][j] = up[i - 1][j]
        //         + 1 | grid[i][j] == 'E'
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        int[][] left = new int[n][m];
        int[][] right = new int[n][m];
        int[][] sums = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (grid[i][j] == 'E') {
                    up[i][j] = up[i - 1][j] + 1;
                } else {
                    up[i][j] = up[i - 1][j];
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (i == n - 1) {
                    down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (grid[i][j] == 'E') {
                    down[i][j] = down[i + 1][j] + 1;
                } else {
                    down[i][j] = down[i + 1][j];
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (j == 0) {
                    left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (grid[i][j] == 'E') {
                    left[i][j] = left[i][j - 1] + 1;
                } else {
                    left[i][j] = left[i][j - 1];
                }
            }
        }

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                    continue;
                }
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (grid[i][j] == 'E') {
                    right[i][j] = right[i][j + 1] + 1;
                } else {
                    right[i][j] = right[i][j + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W' || grid[i][j] == 'E') {
                    continue;
                }
                if (i > 0) {
                    sums[i][j] += up[i - 1][j];
                }
                if (i < n - 1) {
                    sums[i][j] += down[i + 1][j];
                }
                if (j > 0) {
                    sums[i][j] += left[i][j - 1];
                }
                if (j < m - 1) {
                    sums[i][j] += right[i][j + 1];
                }
                if (sums[i][j] > max) {
                    max = sums[i][j];
                }
            }
        }

        return max;
    }
}
