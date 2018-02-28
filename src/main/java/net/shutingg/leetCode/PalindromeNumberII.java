package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/palindrome-number-ii/
 */
public class PalindromeNumberII {
    /**
     * Can be improved by using int[] and bit operation
     *
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        if (n == 0) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n % 2);
            n = n / 2;
        }
        char[] cs = sb.toString().toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
