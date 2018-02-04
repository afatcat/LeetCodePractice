package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * Window Pointers
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s==null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        char[] cs = s.toCharArray();
        int[] hash = new int[256];//ascii
        int j = 0;
        int result = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && (l < k || hash[cs[j]] > 0)) {
                if (hash[cs[j]] == 0) {
                    l++;
                }
                hash[cs[j]]++;
                j++;
            }
            result = Math.max(result, j - i);
            if (j == n) {
                break;
            }
            hash[cs[i]]--;
            if (hash[cs[i]] == 0) {
                l--;
            }
        }

        return result;
    }
}
