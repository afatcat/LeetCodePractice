package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/string-permutation-ii/
 */
public class StringPermutationII {
    /**
     * DFS
     *
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }

        if (str.length() == 0) {
            res.add("");
            return res;
        }

        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        dfs(res, cs, "");
        return res;
    }

    private void dfs(List<String> res, char[] cs, String cur) {
        int n = cur.length();
        if (n == cs.length) {
            res.add(cur);
            return;
        }

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '*' || i > 0 && cs[i] == cs[i - 1]) {
                continue;
            }
            char tmp = cs[i];
            cs[i] = '*';
            dfs(res, cs, cur + tmp);
            cs[i] = tmp;
        }
    }
}
