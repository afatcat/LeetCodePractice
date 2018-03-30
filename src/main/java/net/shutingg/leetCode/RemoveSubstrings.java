package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.lintcode.com/en/problem/remove-substrings/
 */
public class RemoveSubstrings {
    /**
     * DFS
     *
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(s);
        return dfs(s, dict, visited);
    }

    private int dfs(String s, Set<String> dict, Set<String> visited) {
        int min = s.length();
        for (String word : dict) {
            int i = s.indexOf(word, 0);
            while (i >= 0) {
                String t = s.substring(0, i) + s.substring(i + word.length(), s.length());
                if (!visited.contains(t)) {
                    visited.add(t);
                    min = Math.min(min, dfs(t, dict, visited));
                }
                i = s.indexOf(word, i + 1);
            }
        }
        return min;
    }
}
