package net.shutingg.leetCode;

import java.util.Arrays;

public class UniquePaths {
    /**
     * DP - coordinate, rolling array
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths3(int m, int n) {
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for(int i = 1; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    f[j] = 1;
                }else{
                    f[j] = f[j] + f[j-1];
                }
            }
        }

        return f[n-1];
    }

    /**
     * DP - coordinate
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        //f[i][j] = f[i-1][j] + f[i][j-1]
        int[][] f = new int[m][n];

        for(int i = 0; i < m; i++){
            f[i][0] = 1;
        }

        for(int j = 1; j < n; j++){
            f[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }

        return f[m-1][n-1];
    }

    /**
     * Math (slower than DP but use O(1))
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths2(int m, int n) {
        //C(m+n-2, n-1)

        if(m < n){
            int tmp = m;
            m = n;
            n = tmp;
        }

        int k = m +n -2;
        int l = n - 1;

        double res = 1;
        for(int i = 1; i <= l; i++){
            res = res * k / i;
            k--;
        }

        return (int) res;
    }
}
