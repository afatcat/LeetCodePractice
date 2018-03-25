package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/backpack-ix/
 *
 * You have a total of 10 * n thousand yuan, hoping to apply for a university abroad. The application is required to pay a certain fee. Give the cost of each university application and the probability of getting the University's offer, and the number of university is m. If the economy allows, you can apply for multiple universities. Find the highest probability of receiving at least one offer.
 *
 * Notice
 * 0<=n<=10000,0<=m<=10000
 *
 * Example
 * Given:
 * n = 10
 * prices = [4,4,5]
 * probability = [0.1,0.2,0.3]
 *
 * Return:0.440
 */
public class BackpackIX {
    /**
     * DP - backpack
     * rolling array
     *
     * price is size/weight
     *
     * @param n: Your money
     * @param prices: Cost of each university application
     * @param probability: Probability of getting the University's offer
     * @return: the  highest probability
     */
    public double backpackIX(int n, int[] prices, double[] probability) {
        //p[i] = 1 - probability[i]
        //f[i][j] = f[i - 1][j], f[i - 1][j - prices[i - 1]] * p[i - 1]
        //f[0][j] = 1
        //f[i][0] = 1

        if (prices == null || prices.length == 0 || probability == null || probability.length == 0 || prices.length != probability.length || n <= 0) {
            return 0.0;
        }

        int m = probability.length;
        double[] p = new double[m];

        for (int i = 0; i < m; i++) {
            p[i] = 1 - probability[i];
        }

        double[][] f = new double[2][n];
        int r1 = 0;
        int r2 = 1;
        for (int i = 0; i <= m; i++) {
            r2 = 1 - r2;
            r1 = 1 - r1;
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[r2][j] = 1;
                    continue;
                }
                f[r2][j] = f[r1][j];
                if (j - prices[i - 1] >= 0) {
                    f[r2][j] = Math.min(f[r2][j], f[r1][j - prices[i - 1] ] * p[i - 1]);
                }
            }
        }
        double res = 1;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, f[r2][j]);
        }
        return 1 - res;
    }
}
