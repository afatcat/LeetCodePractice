package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * http://lintcode.com/en/problem/longest-palindrome/
 */
public class LongestPalindrome {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if (s == null || s == "") {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }
        int count = 0;
        int odd = 0;
        for (Character c: map.keySet()) {
            if (map.get(c) % 2 == 0) {
                count += map.get(c);
            } else {
                if (map.get(c) >= odd) {
                    if (odd > 0) {
                        count += (odd - 1);
                    }
                    odd = map.get(c);
                } else {
                    count += (map.get(c) - 1);
                }
            }
        }
        return count + odd;
    }
}
