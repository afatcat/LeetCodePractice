package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/valid-number/
 */
public class ValidNumber {
    /**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        if(s == null) {
            return false;
        }
        s = s.trim();
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n == 0) {
            return false;
        }
        int i = 0;
        if (cs[0] == '+' || cs[0] == '-') {
            i++;
        }
        if (i == n) {
            return false;
        }
        boolean afterDecimal = false;

        if (cs[i] == '.') {
            afterDecimal = true;
            if (i + 1 >= n || cs[i + 1] > '9' || cs[i + 1] < '0') {
                return false;
            }
            i = i + 2;
        } else if (cs[i] > '9' || cs[i] < '0') {
            return false;
        } else {
            i++;
        }

        boolean foundE = false;
        while (i < n) {
            if (cs[i] == '.') {
                if (afterDecimal) {
                    return false;
                }
                afterDecimal = true;
                i++;
            } else if (cs[i] <= '9' && cs[i] >= '0') {
                i++;
            } else if (cs[i] == 'e') {
                foundE = true;
                break;
            } else {
                return false;
            }
        }

        if (afterDecimal && cs[i - 1] == 0) {
            return false;
        }

        if (foundE) {
            i++;
            if (i >= n) {
                return false;
            }
            if (cs[i] == '+' || cs[i] == '-') {
                i++;
            }
            if (i >= n || cs[i] > '9' || cs[i] < '0') {
                return false;
            }
            if (cs[i] == '0') {
                if (i + 1 >= n) {
                    return false;
                }
            }
            i++;
            while (i < n) {
                if (cs[i] > '9' || cs[i] < '0') {
                    return false;
                }
            }
        }

        return true;
    }
}
