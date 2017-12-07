package net.shutingg.leetCode;

public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int n = A.length;
        if(n == 0){
            return 0;
        }
        boolean[][] f = new boolean[m+1][n+1];
        for(int i = 0; i <= n; i++){
            f[0][i] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                f[j][i] = f[j][i-1];
                if (j-A[i-1]>=0){
                    f[j][i] |= f[j-A[i-1]][i-1];
                }
            }
        }
        for(int i = m; i >=0; i--){
            if(f[i][n]){
                return i;
            }
        }
        return 0;
    }
}
