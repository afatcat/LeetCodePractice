package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/decode-ways/
 */
public class DecodeWays {
    /**
     * DP
     *
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // f[n] = f[n-1] + f[n-2] | cs[n-2] == 1 or cs[n-2] == 2 && 1 <= cs[n-1] <=6

        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] f = new int[n];
        if (cs[0] == '0') {
            f[0] = 0;
        } else {
            f[0] = 1;
        }
        if (n == 1) {
            return f[0];
        }
        if (twoDigitValid(cs[0], cs[1]) && cs[1] != '0') {
            f[1] = 2;
        } else {
            f[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            f[i] = 0;
            if (twoDigitValid(cs[i - 1], cs[i])) {
                f[i] += f[i - 2];
            }
            if (cs[i] != '0') {
                f[i] += f[i - 1];
            }
        }
        return f[n - 1];
    }

    private boolean twoDigitValid(char prev, char cur) {
        if (prev == '1') {
            return true;
        } else if (prev == '2') {
            if (cur >= '0' && cur <= '6') {
                return true;
            }
        }
        return false;
    }
}
