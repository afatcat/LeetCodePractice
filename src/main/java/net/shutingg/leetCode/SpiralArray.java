package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/spiral-array/
 */
public class SpiralArray {
    /**
     * @param n: a Integer
     * @return: a spiral array
     */
    public int[][] spiralArray(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int[][] res = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int j = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n * n; i++) {
            res[x][y] = i + 1;
            visited[x][y] = true;
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                j = (j + 1) % 4;
                nx = x + dx[j];
                ny = y + dy[j];
            }
            x = nx;
            y = ny;
        }

        return res;
    }
}
