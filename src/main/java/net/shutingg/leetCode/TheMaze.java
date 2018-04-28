package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/the-maze/description/
 */
public class TheMaze {
    /**
     * BFS
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null || maze.length == 0 || start.length != 2 || destination.length != 2) {
            return false;
        }

        int n = maze.length;
        int m = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (visited.contains(point[0] * m + point[1])) {
                continue;
            }
            visited.add(point[0] * m + point[1]);
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny] == 1) {
                    continue;
                }
                int nnx = nx + dx[i];
                int nny = ny + dy[i];
                while (nnx >= 0 && nnx < n && nny >= 0 && nny < m && maze[nnx][nny] == 0) {
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                    nnx = nx + dx[i];
                    nny = ny + dy[i];
                }

                if (nx == destination[0] && ny == destination[1]) {
                    return true;
                }

                if (!visited.contains(nx * m + ny)) {
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
