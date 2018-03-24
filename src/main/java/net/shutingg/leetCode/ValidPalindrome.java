package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/valid-palindrome/
 */
public class ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (!Character.isLetter(cs[i]) && !Character.isDigit(cs[i])) {
                i++;
                continue;
            }
            if (!Character.isLetter(cs[j]) && !Character.isDigit(cs[j])) {
                j--;
                continue;
            }
            if (Character.toLowerCase(cs[i]) != Character.toLowerCase(cs[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
