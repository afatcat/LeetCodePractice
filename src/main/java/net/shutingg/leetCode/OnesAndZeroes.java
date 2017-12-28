package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/ones-and-zeroes/
 */
public class OnesAndZeroes {
    /**
     * DP - duel sequence
     * @param strs: an array with strings include only 0 and 1
     * @param m: An integer
     * @param n: An integer
     * @return: find the maximum number of strings
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //f[i][j][k] = max(f[i-1][j][k], f[i-1][j-A[i-1]][k-B[i-1]]) + 1)
        //f[0][j][k] = 0
        if(strs == null){
            return 0;
        }

        int l = strs.length;
        int[] A = new int[l+1];
        int[] B = new int[l+1];
        for(int i = 1; i <= l; i++){
            char[] cs = strs[i-1].toCharArray();
            for(int j = 0; j < cs.length; j++){
                if(cs[j] == '0'){
                    A[i-1] += 1;
                }else if(cs[j] == '1'){
                    B[i-1] += 1;
                }
            }
        }

        int[][][] f = new int[l+1][m+1][n+1];
        for(int i = 1; i <= l; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    f[i][j][k] = f[i-1][j][k];
                    if(j >= A[i-1] && k >= B[i-1]){
                        f[i][j][k] = Math.max(f[i][j][k], f[i-1][j-A[i-1]][k-B[i-1]] + 1);
                    }
                }
            }
        }

        return f[l][m][n];
    }
}
