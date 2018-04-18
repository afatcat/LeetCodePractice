package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-pairs/description/
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        Map<String, Integer> indexes = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            indexes.put(words[i], i);
        }
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String str1 = word.substring(0, j);
                String str2 = word.substring(j, word.length());
                if (isPar(str1)) {
                    String pair = (new StringBuilder(str2)).reverse().toString();
                    if (indexes.containsKey(pair) && indexes.get(pair) != indexes.get(word)) {
                        res.add(Arrays.asList(indexes.get(pair), indexes.get(word)));
                    }
                }

                if (isPar(str2)) {
                    String pair = (new StringBuilder(str1)).reverse().toString();
                    if (indexes.containsKey(pair) && indexes.get(pair) != indexes.get(word) && str2.length() > 0) {
                        res.add(Arrays.asList(indexes.get(word), indexes.get(pair)));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPar(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
