package net.shutingg.leetCode;

import java.util.PriorityQueue;

/**
 * http://lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/
 */
public class KthSmallestNumberInSortedMatrix {
    /**
     * Priority Queue + matrix
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || k < 0) {
            //invalid input
            return -1;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        if(k > m * n) {
            //invalid input
            return -1;
        }
        boolean[][] hash = new boolean[m][n];


        PriorityQueue<Point> queue = new PriorityQueue<>(m*n, (a, b) -> a.val - b.val);
        queue.add(new Point(0, 0, matrix[0][0]));
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        for(int i = 1; i < k; i++) {
            Point cur = queue.poll();
            for(int j = 0; j < 2; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if(nx < m && ny < n && !hash[nx][ny]) {
                    hash[nx][ny] = true;
                    queue.offer(new Point(nx, ny, matrix[nx][ny]));
                }
            }
        }
        Point cur = queue.poll();
        return cur.val;
    }

    class Point {
        int x;
        int y;
        int val;

        Point (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
