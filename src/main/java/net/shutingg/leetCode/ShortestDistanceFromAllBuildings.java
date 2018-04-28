package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
 */
public class ShortestDistanceFromAllBuildings {
    private int n;
    private int m;

    /**
     * BFS
     *
     * @param grid
     * @return
     */
    public int shortestDistance(int[][] grid) {
        //shortest(i, j, k) = min(shortest(i, j, k - 1), shortest(i, k, k - 1) + shortest(k, j, k - 1))
        //shortest(i, j, 0) = w(i, j)
        //for k, i, j
        //    f[i][j] = f[i][k] + f[k][j]
        if (grid == null) {
            return -1;
        }
        n = grid.length;
        if (n == 0) {
            return -1;
        }
        m = grid[0].length;

        int[][] dist = new int[n][m];
        int[][] sum = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fillDist(new Cell(i, j), grid, dist);
                    sumCells(grid, dist, sum);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, sum[i][j]);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    private void fillDist(Cell cell, int[][] grid, int[][] dist) {
        for (int k = 0; k < n; k++) {
            Arrays.fill(dist[k], Integer.MAX_VALUE);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(cell);
        dist[cell.x][cell.y] = 0;

        while (!queue.isEmpty()) {
            Cell c = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + c.x;
                int ny = dy[k] + c.y;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0 && dist[nx][ny] > dist[c.x][c.y] + 1) {
                    dist[nx][ny] = dist[c.x][c.y] + 1;
                    queue.offer(new Cell(nx, ny));
                }
            }
        }
    }

    private void sumCells(int[][] grid, int[][] dist, int[][] sum) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sum[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (grid[i][j] == 0) {
                    if (dist[i][j] != Integer.MAX_VALUE) {
                        sum[i][j] += dist[i][j];
                    } else {
                        sum[i][j] = Integer.MAX_VALUE;
                    }
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
