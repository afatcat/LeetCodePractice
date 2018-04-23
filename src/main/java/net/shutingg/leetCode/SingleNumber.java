package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/single-number/
 */
public class SingleNumber {
    /**
     * a ^ b ^ b = a
     * https://www.jiuzhang.com/tutorial/bit-manipulation/84
     *
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result = (result ^ A[i]);
        }

        return result;
    }
}
