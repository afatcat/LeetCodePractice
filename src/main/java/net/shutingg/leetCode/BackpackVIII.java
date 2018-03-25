package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/backpack-viii/
 *
 * Give some coins of different value and their quantity. Find how many values which are in range 1 ~ n can these coins be combined
 *
 * Example
 * Given:
 * n = 10
 * value = [1,2,4]
 * amount = [2,1,1]
 *
 * Return: 8
 * They can combine all the values in 1 ~ 8
 */
public class BackpackVIII {
    /**
     * DP - backpack
     * limited amount, count possible value under n
     *
     * @param n: the value from 1 - n
     * @param value: the value of coins
     * @param amount: the number of coins
     * @return: how many different value
     */
    public int backPackVIII(int n, int[] value, int[] amount) {
        //f[v][i] = f[v - value[i]] ||...|| f[v - k * value[i]]

        if (value == null || value.length == 0 || amount == null || value.length != amount.length || n == 0) {
            return 0;
        }

        int m = value.length;
        boolean[][] f= new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    f[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    f[i][j] = false;
                    continue;
                }
                f[i][j] = f[i - 1][j];
                for (int k = 1; k <= amount[i - 1] && !f[i][j]; k++) {
                    if (j - k * value[i - 1] >= 0) {
                        f[i][j] |= f[i - 1][j - k * value[i - 1]];
                    } else {
                        break;
                    }
                }
            }
        }
        int count = 0;
        for (int j = 1; j <= n; j++) {
            if (f[m][j]) {
                count++;
            }
        }
        return count;
    }
}
