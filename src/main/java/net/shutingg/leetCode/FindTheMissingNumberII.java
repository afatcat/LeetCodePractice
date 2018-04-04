package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/find-the-missing-number-ii/
 */
public class FindTheMissingNumberII {
    private String result;
    /**
     * Combination DFS
     *
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    public int findMissing2(int n, String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(String.valueOf(i));
        }

        dfs(set, str, 0);
        return Integer.valueOf(result);
    }

    private void dfs(Set<String> set, String str, int index) {
        int m = str.length();
        if (index == m) {
            if (set.size() > 1) {
                return;
            }
            for (String s : set) {
                result = s;
            }
            return;
        }

        String s1 = str.substring(index, index + 1);
        if (set.contains(s1)) {
            set.remove(s1);
            dfs(set, str, index + 1);
            set.add(s1);
        }
        if (index + 2 > m) {
            return;
        }
        String s2 = str.substring(index, index + 2);
        if (set.contains(s2)) {
            set.remove(s2);
            dfs(set, str, index + 2);
            set.add(s2);
        }
    }
}
