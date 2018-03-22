package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/big-integer-multiplication/
 */
public class BigIntegerMultiplication {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        List<Integer> list = new ArrayList<>();
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        for (int i = cs1.length - 1; i >= 0; i--) {
            for (int j = cs2.length - 1; j >= 0; j--) {
                int d1 = cs1[i] - '0';
                int d2 = cs2[j] - '0';
                int mul = d1 * d2;
                int loc = cs1.length - i - 1 + cs2.length - j - 1;
                if (list.size() - 1 < loc) {
                    list.add(mul);
                } else {
                    list.set(loc, list.get(loc) + mul);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < list.size(); i++) {
            int d = list.get(i) + carry;
            sb.insert(0, d % 10);
            carry = d / 10;
        }

        while (carry != 0) {
            sb.insert(0, carry % 10);
            carry = carry / 10;
        }

        return sb.toString();
    }
}
