package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/maximal-rectangle/
 */
public class MaximalRectangle {
    /**
     * DP - multi arrays
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if(matrix == null){
            return 0;
        }
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        if(n == 0){
            return 0;
        }

        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!matrix[i][j]){
                    continue;
                }
                if(i == 0){
                    up[i][j] = 1;
                    continue;
                }
                up[i][j] = up[i-1][j] + 1;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!matrix[i][j]){
                    continue;
                }
                if(j == 0){
                    continue;
                }

                int tmp = 0;
                for(int k = j-1; k >=0; k--){
                    if(up[i][k] >= up[i][j]){
                        tmp++;
                    }else{
                        break;
                    }
                }
                left[i][j] = tmp;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = n-1; j >=0; j--){
                if(!matrix[i][j]){
                    continue;
                }
                if(j == n-1){
                    continue;
                }

                int tmp = 0;
                for(int k = j+1; k < n; k++){
                    if(up[i][k] >= up[i][j]){
                        tmp++;
                    }else{
                        break;
                    }
                }
                right[i][j] = tmp;
            }
        }

        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]){
                    res = Math.max(res, up[i][j] * (left[i][j] + 1 + right[i][j]));
                }
            }
        }
        return res;
    }
}
