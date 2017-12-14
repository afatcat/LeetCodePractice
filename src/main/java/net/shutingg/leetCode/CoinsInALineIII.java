package net.shutingg.leetCode;

/**
 * DP - section + game theory
 * http://www.lintcode.com/en/problem/coins-in-a-line-iii/
 */
public class CoinsInALineIII {
    /*
     * Memoization
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }

        int[][] f = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                f[i][j] = -1;
            }
        }

        calculate(values, f, 0, n-1);
        return f[0][n-1] >= 0;
    }

    private void calculate(int[] values, int[][] f, int i, int j){
        if(f[i][j] != -1){
            return;
        }

        if(i+1 == j){
            f[i][j] = Math.max(values[i] - values[j], values[j] - values[i]);
            return;
        }

        calculate(values, f, i+1, j);
        calculate(values, f, i, j-1);
        f[i][j] = Math.max(-f[i+1][j]+values[i], -f[i][j-1]+values[j]);
    }
}
