package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/nearest-exit/
 */
public class NearestExit {
    /**
     * Grid BFS
     *
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int n = rooms.length;
        int m = rooms[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Cell> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Cell(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                int nv = cell.val + 1;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && rooms[nx][ny] > 0 && rooms[nx][ny] > nv) {
                    rooms[nx][ny] = nv;
                    queue.offer(new Cell(nx, ny, nv));
                }
            }
        }
    }

    class Cell {
        int x;
        int y;
        int val;
        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
