package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/number-of-subsequences-of-form-ai-bj-ck/
 */
public class NumberOfSubsequencesOfFormAiBjCk {
    /**
     * DP
     *
     * @param : the input string
     * @return: the number of subsequences
     */
    public int countSubsequences(String source) {
        //xa[i] = xa[i - 1] * 2 + 1 | cs[i] == 'a'
        //OR xa[i] = xa[i - 1]
        //xb[i] = xb[i - 1] * 2 + xa[i - 1] | cs[i] == 'b'
        //OR xb[i] = xb[i - 1]
        //xc[i] = xc[i - 1] * 2 + xb[i - 1] | cs[i] == 'c'
        //OR xc[i] = xc[i - 1];
        if (source == null) {
            return 0;
        }

        int n = source.length();
        if (n < 3) {
            return 0;
        }
        char[] cs = source.toCharArray();

        int[] xa = new int[n];
        int[] xb = new int[n];
        int[] xc = new int[n];
        xa[0] = cs[0] == 'a' ? 1 : 0;
        xb[0] = 0;
        xc[0] = 0;
        for (int i = 1; i < n; i++) {
            xa[i] = cs[i] == 'a' ? xa[i - 1] * 2 + 1 : xa[i - 1];
            xb[i] = cs[i] == 'b' ? xb[i - 1] * 2 + xa[i - 1] : xb[i - 1];
            xc[i] = cs[i] == 'c' ? xc[i - 1] * 2 + xb[i - 1] : xc[i - 1];
        }

        return xc[n - 1];
    }
}
