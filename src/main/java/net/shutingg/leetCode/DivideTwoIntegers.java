package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/divide-two-integers/description/
 */
public class DivideTwoIntegers {
    /**
     * Binary Search + bit op + Integer overflow
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

        boolean sign = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;

        long a = Math.abs((long) dividend); //prevent overflow
        long b = Math.abs((long) divisor);

        long multiplier = 0;
        while(a >= b){
            long m = 1;
            long d = b;
            while(a >= (d<<1)){
                d = d << 1;
                m = m << 1;
            }
            a = a - d;
            multiplier += m;
        }

        return sign ? (int) multiplier : -(int)(multiplier);
    }


    /**
     * DP+binary search+bit operation+integer overflow
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide2(int dividend, int divisor) {
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


    /**
     * DP practice again
     *
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide3(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        boolean negative = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            negative = true;
        }
        long d1 = Math.abs((long) dividend);
        long d2 = Math.abs((long) divisor);

        long[] sum = new long[31];
        sum[0] = (long) d2;
        int i = 0;
        while (sum[i] + sum[i] <= d1) {
            sum[i + 1] = sum[i] + sum[i];
            i++;
        }
        long res = 0;
        while (d1 >= d2 && i >= 0) {
            if (d1 >= sum[i]) {
                d1 = d1 - sum[i];
                res += 1 << i;
            }
            i--;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (negative) {
            return (int) -res;
        }
        return (int) res;
    }
}
