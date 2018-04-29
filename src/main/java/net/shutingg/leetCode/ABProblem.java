package net.shutingg.leetCode;

/**
 * https://www.lintcode.com/en/problem/a-b-problem/
 * Bit Operation
 */
public class ABProblem {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = (a ^ b);
            b = ((tmp & b) << 1);
        }

        return a;
    }
}
