package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/interleaving-string/description/
 * http://www.lintcode.com/en/problem/interleaving-string/
 */
public class InterleavingString {
    /**
     * DP - double sequence
     *
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()){
            return false;
        }
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();
        char[] C = s3.toCharArray();

        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for(int i = 1; i <= m; i++){
            f[i][0] = A[i-1] == C[i-1];
        }
        for(int j = 1; j <= n; j++){
            f[0][j] = B[j-1] == C[j-1];
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                f[i][j] = f[i-1][j] && A[i-1] == C[i+j-1];
                f[i][j] |= f[i][j-1] && B[j-1] == C[i+j-1];
            }
        }

        return f[m][n];
    }
}
