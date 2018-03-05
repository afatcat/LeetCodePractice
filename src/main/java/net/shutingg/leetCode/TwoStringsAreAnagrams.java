package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/two-strings-are-anagrams/
 */
public class TwoStringsAreAnagrams {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }

        int[] sc = new int[256];

        for (char c : s.toCharArray()) {
            sc[c]++;
        }
        for (char c : t.toCharArray()) {
            sc[c]--;
            if (sc[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
