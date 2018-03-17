package net.shutingg.leetCode;

import java.util.PriorityQueue;

/**
 * http://www.lintcode.com/en/problem/trapping-rain-water-ii/
 */
public class TrappingRainWaterII {
    /**
     * PriorityQueue
     *
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        if (heights == null) {
            return 0;
        }
        int n = heights.length;
        int m = heights[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>(n * m, (a, b) -> a.h - b.h);
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            visited[i][0] = true;
            pq.offer(new Cell(i, 0, heights[i][0]));
            visited[i][m - 1] = true;
            pq.offer(new Cell(i, m - 1, heights[i][m - 1]));
        }

        for (int j = 0; j < m; j++) {
            visited[0][j] = true;
            pq.offer(new Cell(0, j, heights[0][j]));
            visited[n - 1][j] = true;
            pq.offer(new Cell(n - 1, j, heights[n - 1][j]));
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int res = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.offer(new Cell(nx, ny, Math.max(heights[nx][ny], cell.h)));
                    res += Math.max(cell.h - heights[nx][ny], 0);
                }
            }
        }

        return res;
    }

    class Cell {
        int x;
        int y;
        int h;

        Cell (int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
