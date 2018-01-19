package net.shutingg.leetCode;

public class CoinChange {
    /**
     * DP - backpack
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // f[w][n] = min(f[w][n-1], f[w-A[n-1]][n]+1)

        int n = coins.length;
        int[][] f = new int[amount+1][n+1];

        for(int i = 0; i <= amount; i++){
            f[i][0] = -1;
        }

        for(int i = 1; i <= amount; i++){
            for(int j = 1; j <= n; j++){
                f[i][j] = f[i][j-1];
                if(i >= coins[j-1] && f[i-coins[j-1]][j] != -1){
                    if(f[i][j] != -1){
                        f[i][j] = Math.min(f[i][j], f[i-coins[j-1]][j] +1);
                    }else{
                        f[i][j] = f[i-coins[j-1]][j] +1;
                    }
                }
            }
        }

        return f[amount][n];
    }
}
