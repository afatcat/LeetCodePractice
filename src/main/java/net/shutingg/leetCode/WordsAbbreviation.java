package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/words-abbreviation/
 */
public class WordsAbbreviation {
    /**
     * Hash and loop
     *
     * @param dict: an array of n distinct non-empty strings
     * @return: an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        if (dict == null || dict.length == 0) {
            return new String[0];
        }

        String[] res = new String[dict.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dict.length; i++) {
            String abb = getAbb(dict[i], 1);
            map.put(abb, map.getOrDefault(abb, 0) + 1);
            res[i] = abb;
        }

        int j = 2;
        while (true) {
            boolean isUnique = true;
            for (int i = 0; i < dict.length; i++) {
                if (map.get(res[i]) > 1) {
                    String abb = getAbb(dict[i], j);
                    map.put(abb, map.getOrDefault(abb, 0) + 1);
                    res[i] = abb;
                    isUnique = false;
                }
            }
            if (isUnique) {
                break;
            } else {
                j++;
            }
        }

        return res;
    }

    private String getAbb(String word, int loc) {
        int n = word.length();
        if (n <= 3) {
            return word;
        }

        if (loc >= n - 2) {
            return word;
        }

        return word.substring(0, loc) + (n - loc - 1) + word.charAt(n - 1);
    }
}
