package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/divide-two-integers/description/
 */
public class DivideTwoIntegers {
    /**
     * DP+binary search+bit operation+integer overflow
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
        }

        int sign = 1;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
            sign = -1;
        }

        long a = Math.abs((long) dividend); //prevent overflow
        long b = Math.abs((long) divisor);

        if(a < b){
            return 0;
        }

        long[] f = new long[31];
        long[] g = new long[31];
        f[0] = b;
        long m = 1;
        g[0] = m;
        long d = b;
        int place = 0;
        while(a >= (d << 1) && (d << 1) <= Integer.MAX_VALUE){
            d = d << 1;
            m = m << 1;
            place++;
            f[place] = d;
            g[place] = m;
        }

        long multiplier = m;
        a = a - f[place];
        place--;
        while(place >= 0){
            if(a >= f[place]){
                a = a - f[place];
                multiplier += g[place];
            }else{
                place--;
            }
        }

        return (int) multiplier * sign;
    }
}
