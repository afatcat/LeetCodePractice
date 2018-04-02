package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/minimum-subtree/
 */
public class MinimumSubtree {
    private int minSum = Integer.MAX_VALUE;
    private TreeNode minNode = null;

    /**
     * Divide and Conquer
     *
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        dfs(root);
        return minNode;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = left + right + node.val;
        if (sum < minSum) {
            minSum = sum;
            minNode = node;
        }

        return sum;
    }
}
