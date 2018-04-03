package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum-ii/
 */
public class BinaryTreeMaximumPathSumII {
    /**
     * Divide and Conquer
     *
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int cur = Math.max(root.val, root.val + left);
        cur = Math.max(cur, root.val + right);
        return cur;
    }
}
