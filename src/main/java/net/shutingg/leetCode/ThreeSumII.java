package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/3sum-ii/
 */
public class ThreeSumII {
    /**
     * Two pointer with minor improvement
     *
     * @param n: an integer
     * @return: the number of solutions
     */
    public int threeSum2(int n) {
        int count = 0;
        int m = (int) Math.sqrt(n);
        for (int i = 0; i <= m; i++) {
            int j = i;
            int k = m;
            while (j <= k) {
                int product = i * i + j * j + k * k;
                if (product == n) {
                    count++;
                    j++;
                    k--;
                } else if (product > n) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}
