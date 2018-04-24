package net.shutingg.leetCode;

/**
 * https://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (min != Integer.MAX_VALUE && prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        return max;
    }
}
