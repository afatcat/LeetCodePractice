package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/word-pattern-ii/
 */
public class WordPatternII {
    /**
     * DFS / backtracking
     *
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        Map<String, String> patternMatcher = new HashMap<>();
        Map<String, String> reverseMatcher = new HashMap<>();

        return dfs(pattern, str, 0, 0, patternMatcher, reverseMatcher);
    }

    private boolean dfs(String pattern, String str, int pIndex, int sIndex, Map<String, String> patternMatcher, Map<String, String> reverseMatcher) {
        if (pIndex == pattern.length() && sIndex == str.length()) {
            return true;
        }
        if (pIndex >= pattern.length() && sIndex < str.length()) {
            return false;
        }
        if (sIndex >= str.length() && pIndex < pattern.length()) {
            return false;
        }

        String currentPattern = pattern.substring(pIndex, pIndex + 1);
        if (patternMatcher.containsKey(currentPattern)) {
            String candidate = patternMatcher.get(currentPattern);
            int index = str.indexOf(candidate, sIndex);
            if (index != sIndex) {
                return false;
            } else {
                return dfs(pattern, str, pIndex + 1, sIndex + candidate.length(), patternMatcher, reverseMatcher);
            }
        }

        for (int i = sIndex + 1; i <= str.length(); i++) {
            String candidate = str.substring(sIndex, i);
            if (reverseMatcher.containsKey(candidate)) {
                continue;
            }
            patternMatcher.put(currentPattern, candidate);
            reverseMatcher.put(candidate, currentPattern);
            if (dfs(pattern, str, pIndex + 1, sIndex + candidate.length(), patternMatcher, reverseMatcher)) {
                return true;
            }
            patternMatcher.remove(currentPattern);
            reverseMatcher.remove(candidate);
        }

        return false;
    }
}
