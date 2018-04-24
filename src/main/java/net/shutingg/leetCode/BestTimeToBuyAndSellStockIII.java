package net.shutingg.leetCode;

public class BestTimeToBuyAndSellStockIII {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        //f[i][0] = 0
        //f[0][1,2,3,4] = Integer.MIN_VALUE
        //f[i][1,3] = Math.max(f[i - 1][j] + prices[i - 1] - prices[i - 2], f[i - 1][j - 1])
        //f[i][2,4] = Math.max(f[i - 1][j - 1] + prices[i - 1] - prices[i - 2], f[i - 1][j])

        if (prices == null) {
            return 0;
        }

        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] f = new int[n + 1][5];
        for (int i = 1; i <= 4; i++) {
            f[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j = j + 2) {
                f[i][j] = f[i - 1][j - 1];
                if (f[i - 1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
            for (int j = 2; j <= 4; j = j + 2) {
                f[i][j] = f[i - 1][j];
                if (f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i -2]);
                }
            }
        }

        return Math.max(f[n][0], Math.max(f[n][2], f[n][4]));
    }
}
