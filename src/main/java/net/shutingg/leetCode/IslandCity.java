package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.lintcode.com/en/problem/island-city/
 *
 * Given a matrix of size n x m, the elements in the matrix are 0、1、2. 0 for the sea, 1 for the island, and 2 for the city on the island(You can assume that 2 is built on 1, ie 2 also represents the island).
 If two 1 are adjacent, then these two 1 belong to the same island. Find the number of islands with at least one city.

 Notice

 We only consider up, down, left and right as adjacent.
 n <= 100，m <= 100.
 You can assume that the four sides of the matrix are surrounded by the sea.
 Have you met this question in a real interview? Yes
 Example
 Given mat =
 [
 [1,1,0,0,0],
 [0,1,0,0,1],
 [0,0,0,1,1],
 [0,0,0,0,0],
 [0,0,0,0,1]
 ]
 , return 0.

 Explanation:
 There are 3 islands, but none of them contain cities.
 Given mat =
 [
 [1,1,0,0,0],
 [0,1,0,0,1],
 [0,0,2,1,2],
 [0,0,0,0,0],
 [0,0,0,0,2]
 ]
 , return 2.

 Explanation:
 There are 3 islands, and two of them have cities.
 */
public class IslandCity {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int count = 0;

    /**
     * UnionFind
     *
     * @param grid: an integer matrix
     * @return: an integer
     */
    public int numIslandCities(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        UnionFind uf = new UnionFind(n * m);
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] > 0) {
                        uf.union(nx * m + ny, i * m + j);
                    }
                }
            }
        }

        Set<Integer> hasCity = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < 2) {
                    continue;
                }
                int root = uf.find(i * m + j);
                hasCity.add(root);
            }
        }

        return hasCity.size();
    }

    class UnionFind {
        int[] father;

        UnionFind(int size) {
            father = new int[size];
            for (int i = 0; i < size; i++) {
                father[i] = i;
            }
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }

            return father[x] = find(father[x]);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            father[rootA] = rootB;
        }
    }
}
