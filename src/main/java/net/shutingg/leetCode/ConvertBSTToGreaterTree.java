package net.shutingg.leetCode;

/**
 * Tree Traverse
 *
 * http://www.lintcode.com/en/problem/convert-bst-to-greater-tree/
 */
public class ConvertBSTToGreaterTree {
    int sum = 0;
    /**
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST(TreeNode root) {
        TreeNode cp = copy(root);
        return cp;
    }

    private TreeNode copy(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode cRight = null;
        if (node.right != null) {
            cRight = copy(node.right);
        }
        sum += node.val;

        TreeNode cp = new TreeNode(sum);

        TreeNode cLeft = null;
        if (node.left != null) {
            cLeft = copy(node.left);
        }
        cp.right = cRight;
        cp.left = cLeft;

        return cp;
    }
}
