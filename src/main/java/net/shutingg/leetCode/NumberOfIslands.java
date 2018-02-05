package net.shutingg.leetCode;

public class NumberOfIslands {
    /**
     * UnionFind
     * http://www.lintcode.com/en/problem/number-of-islands/
     * http://www.jiuzhang.com/solution/number-of-islands/
     *
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);

        //count 0
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]) {
                    count++;
                }
            }
        }
        uf.count = count;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    //look down
                    if (i < m - 1 && grid[i+1][j]) {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    //look right
                    if (j < n - 1 && grid[i][j+1]) {
                        uf.union(i * n + j, i * n + (j + 1));
                    }
                }
            }
        }

        return uf.count;
    }

    private class UnionFind {
        int[] fathers = null;
        int count;

        UnionFind (int n) {
            fathers = new int[n];
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
            }
        }

        int find (int x) {
            if (fathers[x] == x) {
                return x;
            }
            fathers[x] = find(fathers[x]);
            return fathers[x];
        }

        void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                fathers[rootY] = rootX;
                count--;
            }
        }
    }

    /**
     * DFS
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0){
            return 0;
        }
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;
        //left
        if(col >=1 && grid[row][col-1]=='1' && !visited[row][col-1]){
            dfs(grid, visited, row, col-1);
        }
        //top
        if(row >=1 && grid[row-1][col]=='1' && !visited[row-1][col]){
            dfs(grid, visited, row-1, col);
        }
        //right
        if(col + 1 < grid[0].length && grid[row][col+1]=='1' && !visited[row][col+1]){
            dfs(grid, visited, row, col+1);
        }
        //bottom
        if(row + 1 <grid.length && grid[row+1][col]=='1' && !visited[row+1][col]){
            dfs(grid, visited, row+1, col);
        }
    }
}
