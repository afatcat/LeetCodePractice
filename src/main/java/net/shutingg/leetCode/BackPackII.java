package net.shutingg.leetCode;

public class BackPackII {
    /*
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        if(n==0){
            return 0;
        }
        int[][] f = new int[n+1][m+1];
        for(int j=0; j<=m; j++){
            f[0][j] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                f[i][j] = f[i-1][j];
                if(j-A[i-1] >= 0){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-A[i-1]]+V[i-1]);
                }
            }
        }
        int result = 0;
        for(int i = m; i >= 1; i--){
            result = Math.max(result, f[n][i]);
        }
        return result;
    }
}
