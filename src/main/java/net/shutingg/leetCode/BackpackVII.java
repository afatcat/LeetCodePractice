package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/backpack-vii/
 *
 * Assume that you have n yuan. There are many kinds of rice in the supermarket. Each kind of rice is bagged and must be purchased in the whole bag. Given the weight, price and quantity of each type of rice, find the maximum weight of rice that you can purchase.
 *
 * Example
 * Given:
 * n = 8
 * prices = [2,4]
 * weight = [100,100]
 * amounts = [4,2]
 *
 * Return:400
 */
public class BackpackVII {
    /**
     * DP - backpack
     * with limited amount, target for max value
     *
     * @param n: the money of you
     * @param prices: the price of rice[i]
     * @param weight: the weight of rice[i]
     * @param amounts: the amount of rice[i]
     * @return: the maximum weight
     */
    public int backPackVII(int n, int[] prices, int[] weight, int[] amounts) {
        //f[i][n] = max(f[i - 1][n], f[i - 1][n - k * prices[i-1]] + k *weight[i - 1])
        //f[0][n] = 0
        //f[i][0] = 0

        if (prices == null || weight == null || amounts == null || prices.length == 0 || prices.length != weight.length || weight.length != amounts.length || n <= 0) {
            return 0;
        }

        int m = prices.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                f[i][j] = f[i - 1][j];
                for (int k = 1; k <= amounts[i - 1]; k++) {
                    if (j - k * prices[i - 1] >= 0) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - k * prices[i - 1]] + k * weight[i - 1]);
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = Math.max(res, f[m][i]);
        }
        return res;
    }
}
