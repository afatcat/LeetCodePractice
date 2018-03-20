package net.shutingg.leetCode;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            leftToStack(root);
        }
    }

    private void leftToStack(TreeNode node) {
        stack.push(node);
        if (node.left != null) {
            leftToStack(node.left);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        if (cur.right != null) {
            leftToStack(cur.right);
        }
        return res;
    }
}
