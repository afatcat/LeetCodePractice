package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
    private List<Integer> list = new ArrayList<>();
    /**
     * Post Order
     *
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return list;
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        list.add(node.val);
    }
}
