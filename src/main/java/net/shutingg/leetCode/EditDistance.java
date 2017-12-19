package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/edit-distance/
 */
public class EditDistance {
    /**
     * DP - duel sequence
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return -1;
        }

        int m = word1.length();
        int n = word2.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] f = new int[m+1][n+1];
        for(int i=0; i <= m; i++){
            f[i][0] = i;
        }
        for(int j=1; j<= n; j++){
            f[0][j] = j;
        }
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                f[i][j] = Math.min(f[i-1][j]+1, f[i][j-1]+1);
                if(cs1[i-1] == cs2[j-1]){
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                }else{
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        return f[m][n];
    }
}
