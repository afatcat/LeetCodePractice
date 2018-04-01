package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    /**
     * Manacher's Algorithm
     * https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
     * O(n) ?
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int max = 1;
        int st = 0;
        int end = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 1; i < n - 1 && i + max / 2 < n; i++) {
            for (int l = 1; i - l >= 0 && i + l < n; l++) {
                if (cs[i - l] != cs[i + l]) {
                    break;
                }
                if (2 * l + 1 > max) {
                    max = 2 * l + 1;
                    st = i - l;
                    end = i + l;
                }
            }
        }
        for (int i = max / 2; i <= n - 2 && i <= n - 1 - max / 2; i++) {
            for (int l = 1; i - l + 1 >= 0 && i + l < n; l++) {
                if (cs[i - l + 1] != cs[i + l]) {
                    break;
                }
                if (2 * l > max) {
                    max = 2 * l;
                    st = i - l + 1;
                    end = i + l;
                }
            }
        }

        return s.substring(st, end + 1);
    }

    /**
     * DP
     * O(n^2)
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
