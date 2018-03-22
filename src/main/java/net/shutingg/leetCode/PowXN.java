package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/powx-n/
 */
public class PowXN {
    /**
     * Bit simulation
     *
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        long l = (long) n;
        if (l < 0) {
            x = 1 / x;
            l = -l;
        }

        double ans = 1;
        double tmp = x;
        while (l > 0) {
            if (l % 2 == 1) {
                ans *= tmp;
            }
            tmp *= tmp;
            l = l / 2;
        }

        return ans;
    }
}
