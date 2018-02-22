package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/kth-prime-number/
 */
public class KthPrimeNumber {
    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public int kthPrime(int n) {
        if (n <= 0) {
            return 0;
        }
        if (!isPrime(n)) {
            return 0;
        }

        int count = 1;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = sqrt; i >= 2; i--) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
