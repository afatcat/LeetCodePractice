package net.shutingg.leetCode;

public class BackpackIII {
    /*
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        int[][] f = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = f[i-1][j];
                if(j - A[i-1]>=0){
                    f[i][j] = Math.max(f[i][j], f[i][j - A[i-1]] + V[i-1]);
                }
            }
        }
        int res = 0;
        for(int j = 0; j <= m; j++){
            res = Math.max(res, f[n][j]);
        }
        return res;
    }
}
