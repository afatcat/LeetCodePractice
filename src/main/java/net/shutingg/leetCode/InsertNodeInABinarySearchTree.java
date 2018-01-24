package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/insert-node-in-a-binary-search-tree/
 */
public class InsertNodeInABinarySearchTree {
    /**
     * Binary Search Tree
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(node == null){
            return root;
        }

        if(root == null){
            return node;
        }
        if(root.val <= node.val){
            root.right = insertNode(root.right, node);
            return root;
        }else{
            root.left = insertNode(root.left, node);
            return root;
        }
    }
}
