package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 */
public class OneBitAndTwoBitCharacters {
    /**
     * DP - sequence
     *
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        //f[i][0] = (f[i - 1][0] || f[i - 1][1]) && bits[i - 1] == 0
        //f[i][1] = (f[i - 2][0] || f[i - 2][1]) && bits[i - 2] == 1

        if (bits == null || bits.length == 0) {
            return false;
        }
        int n = bits.length;
        boolean[][] f = new boolean[n + 1][2];
        f[0][0] = true;
        f[0][1] = true;
        for (int i = 1; i <= n; i++) {
            f[i][0] = (f[i - 1][0] || f[i - 1][1]) && (bits[i - 1] == 0);
            if (i >= 2) {
                f[i][1] = (f[i - 2][0] || f[i - 2][1]) && (bits[i - 2] == 1);
            } else {
                f[i][1] = false;
            }
        }

        return f[n][0];
    }
}
