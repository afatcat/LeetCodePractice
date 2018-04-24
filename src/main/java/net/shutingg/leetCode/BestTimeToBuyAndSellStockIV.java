package net.shutingg.leetCode;

/**
 * https://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStockIV {
    /**
     * DP - sequence
     *
     * @param K: An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public int maxProfit(int K, int[] prices) {
        //f[i][0] = 0
        //f[0][1,2,3,4] = Integer.MIN_VALUE
        //f[i][1,3,5..., 2k - 1] = max(f[i - 1][j] + prices[i - 1] - prices[i - 2], f[i - 1][j - 1])
        //f[i][2,4,6..., 2k] = max(f[i - 1][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2])
        if (K <= 0 || prices == null) {
            return 0;
        }
        int n = prices.length;

        if (2 * K >= n) {
            //f[i] = max(f[i - 1], f[i - 1] + prices[i - 1] - prices[i - 2]
            int[] f = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1];
                if (prices[i - 1] > prices[i - 2]) {
                    f[i] = Math.max(f[i], f[i - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            return f[n];
        }

        int[][] f = new int[n + 1][2 * K + 1];
        for (int j = 1; j <= 2 * K; j++) {
            f[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * K - 1; j = j + 2) {
                f[i][j] = f[i - 1][j - 1];
                if (f[i - 1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
            for (int j = 2; j <= 2 * K; j = j + 2) {
                f[i][j] = f[i - 1][j];
                if (f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
        }

        int max = 0;
        for (int j = 2; j <= 2 * K; j = j + 2) {
            max = Math.max(max, f[n][j]);
        }

        return max;
    }
}
