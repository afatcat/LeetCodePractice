package net.shutingg.leetCode;

/**
 * http://lintcode.com/en/problem/remove-node-in-binary-search-tree/
 */
public class RemoveNodeInBinarySearchTree {
    /**
     * Binary Search Tree
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if(root == null){
            return null;
        }

        if(root.val == value){
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            insertLeft(root.right, root.left);
            return root.right;
        }
        remove(root, value);
        return root;
    }

    private void remove(TreeNode node, int value){
        if(node.val > value){
            if(node.left == null){
                return;
            }
            if(node.left.val == value){
                if(node.left.left == null){
                    node.left = node.left.right;
                    return;
                }
                if(node.left.right == null){
                    node.left = node.left.left;
                    return;
                }
                insertLeft(node.left.right, node.left.left);
                node.left = node.left.right;
                return;
            }
            remove(node.left, value);
        }
        if(node.val < value){
            if(node.right == null){
                return;
            }
            if(node.right.val == value){
                if(node.right.left == null){
                    node.right = node.right.right;
                    return;
                }
                if(node.right.right == null){
                    node.right = node.right.left;
                    return;
                }
                insertLeft(node.right.right, node.right.left);
                node.right = node.right.right;
                return;
            }
            remove(node.right, value);
        }
    }

    private void insertLeft(TreeNode node, TreeNode left){
        if(node.left != null){
            insertLeft(node.left, left);
        }else{
            node.left = left;
        }
    }
}
