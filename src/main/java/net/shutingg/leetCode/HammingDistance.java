package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/hamming-distance/description/
 */
public class HammingDistance {
    /**
     * bit operation
     * x / 2 i.e. x >> 1
     * x % 2 i.e. x & 1
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                count++;
            }
            z = z >> 1;
        }
        return count;
    }
}
