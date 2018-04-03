package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
    /**
     * Divide and Conquer
     *
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right == 0) {
            return 1;
        }
        if (left == 0) {
            return 1 + right;
        }
        if (right == 0) {
            return 1 + left;
        }
        return 1 + Math.min(left, right);
    }
}
