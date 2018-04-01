package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/knight-shortest-path/
 */
public class KnightShortestPath {
    /**
     * Matrix BFS
     *
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || source == null || destination == null || grid.length == 0) {
            return -1;
        }

        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        int n = grid.length;
        int m = grid[0].length;

        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        Queue<Integer> pQ = new LinkedList<>();
        queue.offer(source);
        pQ.offer(0);
        grid[source.x][source.y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int p = pQ.poll();
            int x = point.x;
            int y = point.y;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == false) {
                    if (destination.x == nx && destination.y == ny) {
                        return p + 1;
                    }
                    grid[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                    pQ.offer(p + 1);
                }
            }
        }

        return -1;
    }
}
