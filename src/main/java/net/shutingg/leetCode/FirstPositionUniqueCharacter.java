package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/first-position-unique-character/
 */
public class FirstPositionUniqueCharacter {
    /**
     * Hash
     *
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] cs = s.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < cs.length; i++) {
            hash[cs[i]]++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (hash[cs[i]] == 1) {
                return i;
            }
        }

        return -1;
    }
}
