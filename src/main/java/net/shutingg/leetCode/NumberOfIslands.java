package net.shutingg.leetCode;

public class NumberOfIslands {
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
