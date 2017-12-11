package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    /*
     * DP solution
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }

        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = 1;
        }
        char[] cs = s.toCharArray();
        for(int len = 1; len <= n-1; len++){
            for(int i = 0; i < n; i++){
                if(i+len > n-1){
                    continue;
                }
                f[i][i+len] = f[i][i];
                if(i+1<=n-1){
                    f[i][i+len] = f[i+1][i+len];
                }

                if(i+len-1 <= n-1){
                    f[i][i+len] = Math.max(f[i][i+len], f[i][i+len-1]);
                }
                if(cs[i] == cs[i+len] && i+1 >= 0 && i+len-1 <= n-1){
                    if(len == 1){
                        f[i][i+len] = 2;
                    }else{
                        f[i][i+len] = Math.max(f[i][i+len], f[i+1][i+len-1]+2);
                    }
                }
            }
        }

        return f[0][n-1];
    }

    /*
     * Memoization
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseqWithMemo(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }

        int[][] f = new int[n][n];

        char[] cs = s.toCharArray();
        calculate(cs, f, 0, n-1);

        return f[0][n-1];
    }

    private int calculate(char[] cs, int[][] f, int i, int j){
        if(f[i][j]!=0){
            return f[i][j];
        }
        if(i == j){
            f[i][j] = 1;
            return 1;
        }else if(i < 0 || j > cs.length-1 || i > j){
            return 0;
        }else if(i+1 == j){
            if(cs[i] == cs[j]){
                f[i][j] = 2;
            }else{
                f[i][j] = 1;
            }
            return f[i][j];
        }else{
            f[i][j] = Math.max(calculate(cs, f, i+1, j), calculate(cs, f, i, j-1));
            if(cs[i] == cs[j]){
                f[i][j] = Math.max(calculate(cs, f, i+1, j-1) + 2, f[i][j]);
            }
            return f[i][j];
        }
    }
}
