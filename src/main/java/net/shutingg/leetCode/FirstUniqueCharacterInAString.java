package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/first-unique-character-in-a-string/
 *
 * FB phone interview
 */
public class FirstUniqueCharacterInAString {
    /**
     * Hash
     *
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] cs = str.toCharArray();
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            counts.put(cs[i], counts.getOrDefault(cs[i], 0) + 1);
        }
        for (int i = 0; i < cs.length; i++) {
            if (counts.get(cs[i]) == 1) {
                return cs[i];
            }
        }

        return 0;
    }
}
