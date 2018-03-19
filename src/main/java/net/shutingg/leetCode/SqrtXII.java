package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/sqrtx-ii/
 */
public class SqrtXII {
    /**
     * double compare
     * binary search
     *
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        if (x == 0) {
            return 0;
        }

        double diff = 0.000000000001;
        double st = 0;
        double end = Math.max(x, 1.0);
        while (st + diff < end) {
            double mid = (end - st) / 2 + st;
            if (mid * mid < x) {
                st = mid;
            } else {
                end = mid;
            }
        }

        return st;
    }
}
