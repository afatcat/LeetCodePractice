package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://lintcode.com/en/problem/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    /**
     * Tree Traverse
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        traverse(root, res);
        return res.get(0);
    }

    private int traverse(TreeNode node, List<Integer> result){
        if(node == null){
            return 0;
        }

        int left = Integer.MIN_VALUE;
        if(node.left != null){
            left = traverse(node.left, result);
        }

        int right = Integer.MIN_VALUE;
        if(node.right != null){
            right = traverse(node.right, result);
        }

        left = node.left != null ? (left > 0 ? left: 0) : 0;
        right = node.right != null ? (right > 0 ? right: 0) : 0;
        int currentPathSum = left + right + node.val;
        if(currentPathSum > result.get(0)){
            result.remove(0);
            result.add(currentPathSum);
        }
        return node.val + Math.max(left, right);
    }
}
