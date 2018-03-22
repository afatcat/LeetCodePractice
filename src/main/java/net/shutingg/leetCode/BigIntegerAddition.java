package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/big-integer-addition/
 */
public class BigIntegerAddition {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }

        int n = num1.length();
        int m = num2.length();
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = n - 1, j = m - 1; i >= 0 || j >= 0; i--, j--) {
            int d1 = i >= 0 ? cs1[i] - '0' : 0;
            int d2 = j >= 0 ? cs2[j] - '0' : 0;
            int add = d1 + d2 + carry;
            sb.insert(0, add % 10);
            carry = add / 10;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
