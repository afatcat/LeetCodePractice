package net.shutingg.leetCode;

public class CopyBooks {
    /*
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        int n = pages.length;
        if(n == 0){
            return 0;
        }

        if(k>n){
            k = n;
        }
        int[][] f = new int[n+1][k+1];
        f[0][0] = 0;
        for(int i=1; i<=n; i++){
            f[i][0] = Integer.MAX_VALUE;
        }
        for(int j=1; j<=k; j++){
            f[0][j] = 0;
            for(int i=1; i<=n; i++){
                f[i][j] = Integer.MAX_VALUE;
                int lastCost = 0;
                for(int l=i; l>=1; l--){
                    lastCost += pages[l-1];
                    f[i][j] = Math.min(f[i][j], Math.max(f[l-1][j-1], lastCost));
                    if(f[l-1][j-1] < lastCost){
                        break;
                    }
                }
            }
        }

        return f[n][k];
    }
}
