package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    /**
     * DP - double sequence
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        if(A == null || B == null){
            return 0;
        }
        int m = A.length();
        int n = B.length();
        if(m == 0 || n == 0){
            return 0;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] f = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                f[i][j] = Math.max(f[i][j-1], f[i-1][j]);
                if(a[i-1] == b[j-1]){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }

        return f[m][n];
    }
}
