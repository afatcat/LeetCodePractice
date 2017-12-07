package net.shutingg.leetCode;

public class CoinsInALine {
    /*
     * http://www.lintcode.com/en/problem/coins-in-a-line/
     * http://www.jiuzhang.com/solutions/coins-in-a-line/
     *
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if(n <= 0) return false;
        boolean[] f = new boolean[n+1];
        f[1] = true;
        if(n>1){
            f[2] = true;
        }

        for(int i=3; i<=n; i++){
            f[i] = !(f[i-1] && f[i-2]);
        }

        return f[n];
    }
}
