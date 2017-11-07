package net.shutingg.leetCode;

/**
 * Created by sguan on 11/1/17.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        return linkNumber(root, 0);
    }

    int linkNumber(TreeNode node, int parentVal){
        if(node.left == null && node.right == null){
            return parentVal*10+node.val;
        }
        int left = 0;
        if(node.left != null){
            left = linkNumber(node.left, parentVal*10+node.val);
        }
        int right = 0;
        if(node.right != null){
            right = linkNumber(node.right, parentVal*10+node.val);
        }
        return left + right;
    }
}
