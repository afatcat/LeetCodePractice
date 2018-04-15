package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {
    /**
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
