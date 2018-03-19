package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/binary-tree-leaves-order-traversal/
 */
public class BinaryTreeLeavesOrderTraversal {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        postOrder(root, res);
        return res;
    }

    private int postOrder(TreeNode node, List<List<Integer>> res) {
        int level = 0;
        if (node.left != null) {
            level = postOrder(node.left, res) + 1;
        }
        if (node.right != null) {
            level = Math.max(level, postOrder(node.right, res) + 1);
        }

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        list.add(node.val);

        return level;
    }
}
