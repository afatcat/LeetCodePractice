package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
public class PacificAtlanticWaterFlow {
    /**
     * BFS
     *
     * @param matrix
     * @return
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] pacifics = new boolean[n][m];
        boolean[][] atlantics = new boolean[n][m];
        Queue<Cell> queue = new LinkedList<>();

        for (int j = 0; j < m; j++) {
            pacifics[0][j] = true;
            queue.offer(new Cell(0, j));
        }
        for (int i = 1; i < n; i++) {
            pacifics[i][0] = true;
            queue.offer(new Cell(i, 0));
        }
        fillCell(queue, matrix, pacifics, n, m);

        for (int j = 0; j < m; j++) {
            atlantics[n - 1][j] = true;
            queue.offer(new Cell(n - 1, j));
        }
        for (int i = 0; i < n - 1; i++) {
            atlantics[i][m - 1] = true;
            queue.offer(new Cell(i, m - 1));
        }
        fillCell(queue, matrix, atlantics, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacifics[i][j] && atlantics[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    private void fillCell(Queue<Cell> queue, int[][] matrix, boolean[][] target, int n, int m) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] >= matrix[cur.x][cur.y] && !target[nx][ny]) {
                    target[nx][ny] = true;
                    queue.offer(new Cell(nx, ny));
                }
            }
        }
    }

    class Cell {
        int x;
        int y;
        Cell (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
