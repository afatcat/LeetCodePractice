package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/three-distinct-factors/
 */
public class ThreeDistinctFactors {
    /*
     * @param n: the given number
     * @return: true if it has exactly three distinct factors, otherwise false
     */
    public boolean isThreeDisctFactors(long n) {
        long sqrt = ((Double) Math.sqrt(n)).longValue();
        if (n == sqrt * sqrt) {
            for (int i = 2; i < sqrt / 2; i++) {
                if (sqrt % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
