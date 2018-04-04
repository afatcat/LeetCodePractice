package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * http://www.lintcode.com/en/problem/generate-parentheses/
 */
public class GenerateParentheses {
    /**
     * Combination DFS
     *
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, res, "");

        return res;
    }

    private void dfs(int left, int right, List<String> res, String cur) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }

        if (left > 0) {
            dfs(left - 1, right + 1, res, cur + "(");
        }
        if (right > 0) {
            dfs(left, right - 1, res, cur + ")");
        }
    }

    /**
     * First Version
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        generator(result, 0, n, "");
        return result;
    }

    private void generator(List<String> list, int leftCount, int rightCount, String str){
        if(rightCount > 0){
            if(leftCount > 0){
                generator(list, leftCount-1, rightCount, str+")");
            }
            generator(list, leftCount+1, rightCount-1, str+"(");
        }else if(leftCount >0){
            generator(list, leftCount-1, rightCount, str+")");
        }else{
            list.add(str);
        }
    }
}
