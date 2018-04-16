package net.shutingg.leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-window-subsequence/description/
 */
public class MinimumWindowSubsequence {
    /**
     * DP
     * f[i][j] = f[i - 1][j - 1] | s[i] == t[j]
     *         = f[i - 1][j] | s[i] != t[j]
     * for j
     *     for i
     *
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        if (S == null || T == null) {
            return "";
        }

        int m = S.length();
        int n = T.length();
        if (n == 0 || m == 0) {
            return "";
        }
        char[] cs = S.toCharArray();
        char[] ct = T.toCharArray();
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }

        if (cs[0] == ct[0]) {
            f[0][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            f[i][0] = cs[i] == ct[0] ? i : f[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (cs[i] == ct[j]) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = n - 1; i < m; i++) {
            if (f[i][n - 1] != Integer.MAX_VALUE && i - f[i][n - 1] < min) {
                min = i - f[i][n - 1];
                result = S.substring(f[i][n - 1], i + 1);
            }
        }

        return result;
    }
}
