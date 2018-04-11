package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/counting-bits/
 */
public class CountingBits {
    /**
     * DP
     * f[i] = f[i / 2] + (i % 1)
     *
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }

        return f;
    }
}
