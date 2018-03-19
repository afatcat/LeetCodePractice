package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/sqrtx/
 */
public class SqrtX {
    /**
     * Binary Search
     *
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long st = 0;
        long end = x;
        long pl = (end - st) / 2 + st;
        while (st + 1 < end) {
            long mul = pl * pl;

            if (mul > (long) x) {
                end = pl;
                pl = (st + end) / 2;
            } else if (mul == (long) x) {
                return (int) pl;
            } else {
                st = pl;
                pl = (st + end) / 2;
            }
        }
        if (end * end == x) {
            return (int) end;
        }
        return (int) st;
    }
}
