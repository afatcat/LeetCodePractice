package net.shutingg.leetCode;

/**
 * https://www.lintcode.com/en/problem/swap-bits/
 *
 * Bit Operation
 */
public class SwapBits {
    /**
     * @param x: An integer
     * @return: An integer
     */
    public int swapOddEvenBits(int x) {
        return ((x & 0xaaaaaaaa) >>> 1) + ((x & 0x55555555) << 1);
    }
}
