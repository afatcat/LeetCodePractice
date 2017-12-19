package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/distinct-subsequences/
 */
public class DistinctSubsequences {
    /**
     * DP - duel sequence
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if(S == null || T == null){
            return 0;
        }
        int m = S.length();
        int n = T.length();
        if(m < n){
            return 0;
        }
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[][] f = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            f[i][0] = 1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                f[i][j] = f[i-1][j];
                if(s[i-1] == t[j-1]){
                    f[i][j] += f[i-1][j-1];
                }
            }
        }

        return f[m][n];
    }
}
