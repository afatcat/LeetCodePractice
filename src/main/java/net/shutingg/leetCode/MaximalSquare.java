package net.shutingg.leetCode;

public class MaximalSquare {
    /**
     * DP 2d
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // f[i][j] = 0 | matrix[i][j] == 0
        // f[i][j] = min(f[i-1][j], f[i][j-1], f[i-1][j-1]) + 1 | matrix[i][j] == 1

        if(matrix == null){
            return 0;
        }
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    f[i][j] = 0;
                }else{
                    int tmp = 0;
                    if(i == 0){
                        f[i][j] = 1;
                        continue;
                    }
                    if(j == 0){
                        f[i][j] = 1;
                        continue;
                    }
                    f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]);
                    f[i][j] = Math.min(f[i][j], f[i][j-1]);
                    f[i][j]++;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, f[i][j]);
            }
        }

        return res * res;
    }
}
