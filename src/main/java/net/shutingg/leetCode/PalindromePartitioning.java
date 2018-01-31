package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://lintcode.com/en/problem/palindrome-partitioning/
 */
public class PalindromePartitioning {
    /**
     * DFS - backtracking
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        dfs(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, String s, int loc) {
        if(loc == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = loc; i < s.length(); i++) {
            if(isValid(s, loc, i)){
                list.add(s.substring(loc, i + 1));
                dfs(result, list, s, i+1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String s, int st, int end) {
        char[] cs = s.toCharArray();
        while (st < end) {
            if(cs[st] != cs[end]) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}
