package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/maximum-submatrix/
 */
public class MaximumSubmatrix {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int max = 0;
        for (int row1 = 1; row1 <= n; row1++) {
            for (int row2 = row1; row2 <= n; row2++) {
                for (int col1 = 1; col1 <= m; col1++) {
                    for (int col2 = col1; col2 <= m; col2++) {
                        int square = prefixSum[row2][col2] - prefixSum[row2][col1 - 1] - prefixSum[row1 - 1][col2] + prefixSum[row1 - 1][col1 - 1];
                        if (square > max) {
                            max = square;
                        }
                    }
                }
            }
        }

        return max;
    }
}
