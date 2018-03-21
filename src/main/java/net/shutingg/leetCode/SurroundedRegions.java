package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/surrounded-regions/
 */
public class SurroundedRegions {
    /**
     * Grid BFS
     *
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;
        Queue<Cell> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Cell(i, 0));
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new Cell(i, m - 1));
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new Cell(0, j));
            }
            if (board[n - 1][j] == 'O') {
                queue.offer(new Cell(n - 1, j));
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            board[cell.x][cell.y] = 'M';
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'O') {
                    queue.offer(new Cell(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j =0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
