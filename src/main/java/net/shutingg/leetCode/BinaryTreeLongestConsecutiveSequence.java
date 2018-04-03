package net.shutingg.leetCode;

public class BinaryTreeLongestConsecutiveSequence {
    private int longest = 0;

    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return longest;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (node.left != null && node.left.val == node.val + 1) {
            left = left + 1;
        } else {
            left = 1;
        }
        if (node.right != null && node.right.val == node.val + 1) {
            right = right + 1;
        } else {
            right = 1;
        }

        longest = Math.max(longest, left);
        longest = Math.max(longest, right);

        return Math.max(left, right);
    }
}
