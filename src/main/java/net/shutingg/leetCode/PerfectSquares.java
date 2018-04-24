package net.shutingg.leetCode;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 0; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }

        return f[n];
    }
}
