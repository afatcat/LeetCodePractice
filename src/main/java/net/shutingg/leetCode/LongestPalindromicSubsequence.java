package net.shutingg.leetCode;

public class LongestPalindromicSubsequence {
    /*
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
}
