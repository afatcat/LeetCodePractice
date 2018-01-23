package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * http://lintcode.com/en/problem/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    /**
     * Tree Traverse
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Pair pair = traverse(root);
        return pair.valid;
    }

    private Pair traverse(TreeNode node) {
        boolean valid = true;
        int min = node.val;
        int max = node.val;
        if(node.left != null){
            Pair left = traverse(node.left);
            valid &= left.valid;
            valid &= left.max < node.val;
            min = Math.min(left.min, min);
        }
        if(node.right != null){
            Pair right = traverse(node.right);
            valid &= right.valid;
            valid &= right.min > node.val;
            max = Math.max(right.max, max);
        }

        return new Pair(min, max, valid);
    }

    class Pair {
        int min;
        int max;
        boolean valid;
        public Pair (int min, int max){
            this.min = min;
            this.max = max;
        }

        public Pair (int min, int max, boolean valid){
            this(min, max);
            this.valid = valid;
        }
    }
}
