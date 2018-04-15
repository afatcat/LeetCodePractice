package net.shutingg.leetCode;

import java.util.*;

/**
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.

 Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".

 The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)

 Example 1:
 Input: "(123)"
 Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 Example 2:
 Input: "(00011)"
 Output:  ["(0.001, 1)", "(0, 0.011)"]
 Explanation:
 0.0, 00, 0001 or 00.01 are not allowed.
 Example 3:
 Input: "(0123)"
 Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 Example 4:
 Input: "(100)"
 Output: [(10, 0)]
 Explanation:
 1.0 is not allowed.


 Note:

 4 <= S.length <= 12.
 S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.
 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> list = new ArrayList<>();
        if (S == null || S.length() <= 2) {
            return list;
        }
        S = S.substring(1, S.length() - 1);
        for (int i = 1; i < S.length(); i++) {
            List<String> first = construct(S.substring(0, i));
            List<String> second = construct(S.substring(i, S.length()));
            for (String part1 : first) {
                for (String part2 : second) {
                    System.out.println("part1: " + part1 +", part2: " + part2);
                    list.add(formatCoordinate(part1, part2));
                }
            }
        }

        return list;
    }

    private String formatCoordinate(String part1, String part2) {
        return "(" + part1 + ", " + part2 + ")";
    }

    private List<String> construct(String str) {
        List<String> list = new ArrayList<>();
        int n = str.length();
        if (n < 1) {
            return list;
        }
        for (int i = 1; i < n; i++) {
            String beforeDecimal = str.substring(0, i);
            String afterDecimal = str.substring(i, n);
            if (beforeDecimalValid(beforeDecimal) && afterDecimalValid(afterDecimal)) {
                list.add(beforeDecimal + "." + afterDecimal);
            }
        }
        if (beforeDecimalValid(str)) {
            list.add(str);
        }

        return list;
    }

    private boolean beforeDecimalValid(String str) {
        char[] cs = str.toCharArray();
        int n = cs.length;
        if (n == 0) {
            return false;
        }
        if (cs[0] == '0' && n > 1) {
            return false;
        }
        return true;
    }

    private boolean afterDecimalValid(String str) {
        char[] cs = str.toCharArray();
        int n = cs.length;
        if (n == 0) {
            return false;
        }
        if (cs[n - 1] == '0') {
            return false;
        }
        return true;
    }
}
