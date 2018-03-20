package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/inorder-successor-in-binary-search-tree/
 */
public class InorderSuccessorInBinarySearchTree {
    /**
     * Tree DFS
     *
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        }
    }
}
