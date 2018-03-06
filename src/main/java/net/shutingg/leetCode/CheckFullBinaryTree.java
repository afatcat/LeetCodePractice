package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/check-full-binary-tree/
 */
public class CheckFullBinaryTree {
    /**
     * Tree
     *
     * @param : the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        return verify(root);
    }

    private boolean verify(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left == null || node.right == null) {
            return false;
        }

        return verify(node.left) && verify(node.right);
    }
}
