package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/ugly-number-ii/description/
 */
public class UglyNumberII {
    /**
     * DP + math
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n <= 0){
            return -1;
        }

        if(n==1){
            return 1;
        }

        int[] f = new int[n];
        f[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i = 1; i < n; i++){
            f[i] = Math.min(f[p2]*2, Math.min(f[p3]*3, f[p5]*5));
            if(f[i] == f[p2]*2){
                p2++;
            }
            if(f[i] == f[p3]*3){
                p3++;
            }
            if(f[i] == f[p5]*5){
                p5++;
            }
        }
        return f[n-1];
    }
}
