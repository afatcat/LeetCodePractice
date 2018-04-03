package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/binary-tree-path-sum-ii/
 */
public class BinaryTreePathSumII {
    /**
     * Tree Backtracking
     *
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, root, new ArrayList<>(), target);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode cur, List<Integer> curList, int target) {
        if (cur == null) {
            return;
        }

        curList.add(cur.val);
        List<Integer> tmpList = new ArrayList<>();
        int sum = 0;
        for (int i = curList.size() - 1; i >= 0; i--) {
            sum += curList.get(i);
            tmpList.add(0, curList.get(i));
            if (sum == target) {
                result.add(new ArrayList<>(tmpList));
            }
        }
        dfs(result, cur.left, curList, target);
        dfs(result, cur.right, curList, target);
        curList.remove(curList.size() - 1);
    }
}
