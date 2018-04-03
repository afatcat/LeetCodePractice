package net.shutingg.leetCode;

import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/inorder-predecessor-in-bst/
 */
public class InorderPredecessorInBST {
    private Stack<TreeNode> stack = new Stack<>();

    /**
     * BST search
     *
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        if (root.val >= p.val) {
            if (root.left != null) {
                return inorderPredecessor(root.left, p);
            } else {
                while (!stack.isEmpty()) {
                    TreeNode last = stack.pop();
                    if (last.val < p.val) {
                        return last;
                    }
                }
                return null;
            }
        } else {
            if (root.right != null) {
                stack.push(root);
                return inorderPredecessor(root.right, p);
            } else {
                return root;
            }
        }
    }
}
