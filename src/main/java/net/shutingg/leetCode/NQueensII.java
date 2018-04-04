package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/n-queens-ii/
 */
public class NQueensII {
    private int count = 0;
    /**
     * DFS
     *
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[][] board = new int[n][n];
        dfs(n, board, 0);
        return count;
    }

    private void dfs(int n, int[][] board, int index) {
        if (index == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean exist = false;
            for (int j = 0; j < index; j++) {
                if (board[j][i] == 1) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                continue;
            }

            int k = index - 1;
            int l = i - 1;
            while (k >= 0 && l >= 0) {
                if (board[k][l] == 1) {
                    exist = true;
                    break;
                }
                k--;
                l--;
            }
            if (exist) {
                continue;
            }
            k = index - 1;
            l = i + 1;
            while (k >= 0 && l < n) {
                if (board[k][l] == 1) {
                    exist = true;
                    break;
                }
                k--;
                l++;
            }
            if (exist) {
                continue;
            }

            board[index][i] = 1;
            dfs(n, board, index + 1);
            board[index][i] = 0;

        }
    }
}
