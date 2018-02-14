package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

/**
 * http://www.lintcode.com/en/problem/number-of-islands-ii/
 */
public class NumberOfIslandsII {
    /**
     * UnionFind
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if (n == 0 || m == 0 || operators == null || operators.length == 0) {
            return result;
        }
        UnionFind uf = new UnionFind(n, m);
        for (Point point:operators) {
            uf.add(point);
            result.add(uf.count);
        }
        return result;
    }

    class UnionFind {
        int[] parent;
        int count;
        int width;
        int height;
        int[][] board;

        UnionFind(int n, int m) {
            parent = new int[n * m];
            board = new int[n][m];
            width = m;
            height = n;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    parent[i * m + j] = i * m + j;
                    board[i][j] = 0;
                }
            }
            count = 0;
        }

        void add(Point p) {
            if (board[p.x][p.y] == 1) {
                return;
            }
            int index = p.x * width + p.y;
            board[p.x][p.y] = 1;
            count++;
            if (p.x < height - 1 && board[p.x + 1][p.y] == 1) {
                union(index, (p.x + 1) * width + p.y);
            }
            if (p.x > 0 && board[p.x - 1][p.y] == 1) {
                union(index, (p.x - 1) * width + p.y);
            }
            if (p.y < width - 1 && board[p.x][p.y + 1] == 1) {
                union(index, p.x * width + (p.y + 1));
            }
            if (p.y > 0 && board[p.x][p.y - 1] == 1) {
                union(index, p.x * width + (p.y - 1));
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            parent[rootA] = rootB;
            count--;
        }
    }
}
