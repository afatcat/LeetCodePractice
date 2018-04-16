package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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

    /**
     * PriorityQueue O(n log n)
     *
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> inQ = new HashSet<>();
        long[] primes = new long[]{2, 3, 5};
        for (int i = 0; i < 3; i++) {
            pq.add(primes[i]);
            inQ.add(primes[i]);
        }
        for (int i = 2; i < n; i++) {
            long current = pq.poll();
            for (int j = 0; j < 3; j++) {
                long next = current * primes[j];
                if (!inQ.contains(next)) {
                    pq.offer(next);
                    inQ.add(next);
                }
            }
        }

        return ((Long) pq.poll()).intValue();
    }
}
