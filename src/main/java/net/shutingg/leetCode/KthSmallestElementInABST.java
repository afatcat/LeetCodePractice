package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInABST {
    private int count = 0;
    private TreeNode kNode = null;
    /**
     * inorder
     *
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kNode.val;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inorder(node.left, k);
        count++;
        if (count == k) {
            kNode = node;
        }
        inorder(node.right, k);
    }
}
