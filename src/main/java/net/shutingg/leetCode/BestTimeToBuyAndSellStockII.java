package net.shutingg.leetCode;

/**
 * https://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {
    /**
     * DP - sequence
     *
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        //f[i] = f[i - 1] | prices[i - 1] <= prices[i - 2]
        //  OR = f[i - 1] + prices[i - 1] - prices[i - 2] | prices[i - 1] > prices[i - 2]
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            if (i > 1 && prices[i - 1] - prices[i - 2] > 0) {
                f[i] += prices[i - 1] - prices[i - 2];
            }
        }

        return f[n];
    }
}
