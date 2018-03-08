package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    /**
     * DP
     *
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // f[i][j] = f[i + 1][j - 1] + 2 | f[i + 1][j - 1] > 0 && cs[i] == cs[j]
        // OR f[i][j] = 0 | f[i + 1][j - 1] == 0 || cs[i] != cs[j]
        // f[i][i] == 1
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] f = new int[n][n];
        int max = 0;
        int st = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j + i < n; j++) {
                if (i == 1) {
                    f[j][j + i] = cs[j] == cs[j + i] ? 2 : 0;
                } else {
                    if (cs[j] == cs[j + i] && f[j + 1][j + i - 1] > 0) {
                        f[j][j + i] = f[j + 1][j + i - 1] + 2;
                    } else {
                        f[j][j + i] = 0;
                    }
                }
                if (f[j][j + i] > max) {
                    st = j;
                    end = j + i;
                    max = f[j][j + i];
                }
            }
        }

        if (max == 0) {
            return "";
        } else {
            return new String(cs, st, end - st + 1);
        }
    }
}
