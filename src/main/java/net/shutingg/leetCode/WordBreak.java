package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class WordBreak {
    /**
     * http://www.lintcode.com/en/problem/word-break/
     * DP with slight improvement
     *
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }

        int maxWordLength = 0;
        for (String word : dict) {
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
        }

        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int j = 0; j <= n; j++) {
            for (int i = Math.max(0, j - maxWordLength); i < j; i++) {
                if (f[i] && dict.contains(s.substring(i, j))) {
                    f[j] = true;
                    break;
                }
            }
        }

        return f[n];
    }

    /**
     * https://leetcode.com/problems/word-break/description/
     * DP
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }

        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[j] && words.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
