package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-abbreviation/description/
 */
public class WordAbbreviation {
    /**
     * Hash
     *
     * @param dict
     * @return
     */
    public List<String> wordsAbbreviation(List<String> dict) {
        if (dict == null || dict.size() == 0) {
            return dict;
        }

        Map<String, Integer> abbCount = new HashMap<>();
        for (String word : dict) {
            String abb = makeAbb(word, 1);
            abbCount.put(abb, abbCount.getOrDefault(abb, 0) + 1);
        }

        String[] resArr = new String[dict.size()];
        int loc = 1;
        while (true) {
            boolean isUnique = true;
            for (int i = 0; i < dict.size(); i++) {
                if (resArr[i] != null) {
                    continue;
                }
                String abb = makeAbb(dict.get(i), loc);
                if (abbCount.get(abb) == 1) {
                    resArr[i] = abb;
                } else {
                    isUnique = false;
                    String nextAbb = makeAbb(dict.get(i), loc + 1);
                    abbCount.put(nextAbb, abbCount.getOrDefault(nextAbb, 0) + 1);
                }
            }
            if (isUnique) {
                break;
            } else {
                loc++;
            }
        }

        return Arrays.asList(resArr);
    }

    private String makeAbb(String word, int loc) {
        int n = word.length();
        if (n <= 3) {
            return word;
        }
        if (loc >= n - 2) {
            return word;
        }

        return word.substring(0, loc) + (n - loc - 1) + word.substring(n - 1, n);
    }
}
