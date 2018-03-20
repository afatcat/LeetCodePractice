package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null) {
            return res;
        }

        char[] cs = S.toCharArray();
        dfs(cs, res, 0, "");
        return res;
    }

    private void dfs(char[] cs, List<String> res, int loc, String current) {
        if (loc == cs.length) {
            res.add(current);
            return;
        }

        if (Character.isLetter(cs[loc])) {
            dfs(cs, res, loc + 1, current + Character.toUpperCase(cs[loc]));
            dfs(cs, res, loc + 1, current + Character.toLowerCase(cs[loc]));
        } else {
            dfs(cs, res, loc + 1, current + cs[loc]);
        }
    }
}
