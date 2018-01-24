package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * Tree Traverse
     * @param root: a TreeNode, the root of the binary tree
     * @return:
     */
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode holder = new TreeNode(0);
        preorder(root, holder);
        print(root);
    }

    private TreeNode preorder(TreeNode node, TreeNode last){
        if(node == null){
            return last;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        last.left = null;
        last.right = node;
        last = node;
        TreeNode nextLast = preorder(left, node);
        return preorder(right, nextLast);
    }

    private void print(TreeNode node){
        if(node != null){
            System.out.println(node.val);
            System.out.print("left: ");
            print(node.left);
            System.out.print("right: ");
            print(node.right);
        }
    }
}
