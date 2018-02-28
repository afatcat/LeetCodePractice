package net.shutingg.leetCode;

/**
 * https://leetcode.com/contest/weekly-contest-73/problems/domino-and-tromino-tiling/
 */
public class DominoAndTrominoTiling {
    /**
     * DP
     *
     * @param N
     * @return
     */
    public int numTilings(int N) {
        //f[i][0] = f[i-1][3]
        //f[i][1] = f[i-1][0] + f[i-1][2]
        //f[i][2] = f[i-1][0] + f[i-1][1]
        //f[i][3] = f[i-1][0] + f[i-1][1] + f[i-1][2] + f[i-1][3]
        //f[0][0] = 0, f[0][1] = 0, f[0][2] = 0, f[0][3] = 1

        if (N == 0) {
            return 0;
        }

        int mod = 1000000007;

        long[][] f = new long[N][4];
        f[0][0] = 1;
        f[0][1] = 0;
        f[0][2] = 0;
        f[0][3] = 1;
        for (int i = 1; i < N; i++) {
            f[i][0] = f[i - 1][3];
            f[i][1] = (f[i - 1][0] + f[i - 1][2]) % mod;
            f[i][2] = (f[i - 1][0] + f[i - 1][1]) % mod;
            f[i][3] = (f[i - 1][0] + f[i - 1][1] + f[i - 1][2] + f[i - 1][3]) % mod;
        }

        return (int) f[N - 1][3];
    }
}
