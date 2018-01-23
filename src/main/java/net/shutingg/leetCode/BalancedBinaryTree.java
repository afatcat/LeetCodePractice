package net.shutingg.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * http://lintcode.com/en/problem/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    /**
     * Tree Traverse
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        Set<TreeNode> unbalanced = new HashSet<>();
        traverse(root, unbalanced);
        return unbalanced.isEmpty();
    }

    private int traverse(TreeNode node, Set unbalanced){
        if(node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        }
        int left = traverse(node.left, unbalanced);
        int right = traverse(node.right, unbalanced);
        if (Math.abs(left - right) > 1) {
            unbalanced.add(node);
        }
        return Math.max(left, right) + 1;
    }
}
