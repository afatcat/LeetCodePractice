package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    /**
     * Tree Traverse
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int count = preorder(root, 1);
        return count;
    }

    private int preorder(TreeNode node, int count){
        int left = count;
        if(node.left != null){
            left = preorder(node.left, count + 1);
        }
        int right = count;
        if(node.right != null){
            right = preorder(node.right, count + 1);
        }
        return Math.max(left, right);
    }
}
