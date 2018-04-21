package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/police-distance/
 *
 * Given a matrix size of n x m, element 1 represents policeman, -1 represents wall and 0 represents empty.
 Now please output a matrix size of n x m, output the minimum distance between each empty space and the nearest policeman

 Notice

 Given a matrix size of n x m， n <= 200，m <= 200.
 We guarantee that each empty space can be reached by one policeman at least.

 Example
 Given mat =

 [
 [0, -1, 0],
 [0, 1, 1],
 [0, 0, 0]
 ]
 return [[2,-1,1],[1,0,0],[2,1,1]].

 The distance between the policeman and himself is 0, the shortest distance between the two policemen to other empty space is as shown above
 Given mat =

 [
 [0, -1, -1],
 [0, -1, 1],
 [0, 0, 0]
 ]
 ````
 return `[[5,-1,-1],[4,-1,0],[3,2,1]]`。
 The shortest distance between the policemen to other 5 empty space is as shown above.
 */
public class PoliceDistance {
    /**
     * @param matrix : the martix
     * @return: the distance of grid to the police
     */
    public int[][] policeDistance(int[][] matrix ) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = Integer.MAX_VALUE;
                } else if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    queue.offer(new Point(i, j));
                }
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || matrix[nx][ny] <= matrix[p.x][p.y] + 1) {
                    continue;
                }

                matrix[nx][ny] = matrix[p.x][p.y] + 1;
                Point np = new Point(nx, ny);
                queue.offer(np);
            }
        }

        return matrix;
    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
