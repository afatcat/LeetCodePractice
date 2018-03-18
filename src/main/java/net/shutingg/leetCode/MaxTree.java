package net.shutingg.leetCode;

import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/max-tree/
 */
public class MaxTree {
    /**
     * Monotonous stack
     *
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            TreeNode cur = new TreeNode(A[i]);

            if (!stack.isEmpty() && stack.peek().val < cur.val) {
                TreeNode last = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < cur.val) {
                    stack.peek().right = last;
                    last = stack.pop();
                }
                cur.left = last;
            }

            stack.push(cur);
        }
        TreeNode root = stack.pop();
        while (!stack.isEmpty()) {
            stack.peek().right = root;
            root = stack.pop();
        }

        return root;
    }
}
