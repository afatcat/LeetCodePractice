package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/add-operators/
 */
public class AddOperators {
    /**
     * DFS
     *
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }

        dfs(num, (long) target, res, "", 0, 0, 0);
        return res;
    }

    private void dfs(String num, long target, List<String> res, String cur, long sum, long last, int loc) {
        if (loc == num.length() && sum == target) {
            res.add(cur);
            return;
        }

        for (int i = loc + 1; i <= num.length(); i++) {
            String s = num.substring(loc, i);
            long l = Long.parseLong(s);
            if (loc == 0) {
                dfs(num, target, res, s, sum + l, l, i);
            } else {
                dfs(num, target, res, cur + "+" + s, sum + l, l, i);
                dfs(num, target, res, cur + "-" + s, sum - l, -l, i);
                dfs(num, target, res, cur + "*" + s, sum - last + last * l, last * l, i);
            }

            if (num.charAt(loc) == '0') {
                break;
            }
        }
    }
}
