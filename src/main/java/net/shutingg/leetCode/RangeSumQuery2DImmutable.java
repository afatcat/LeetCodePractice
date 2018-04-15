package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
public class RangeSumQuery2DImmutable {
    private int[][] sums;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        int n = matrix.length;
        int m = matrix.length > 0 ? matrix[0].length : 0;
        sums = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sums[i][j + 1] = matrix[i][j] + sums[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum = sum + sums[i][col2 + 1] - sums[i][col1];
        }

        return sum;
    }
}
