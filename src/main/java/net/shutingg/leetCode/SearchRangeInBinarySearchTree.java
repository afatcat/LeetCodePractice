package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://lintcode.com/en/problem/search-range-in-binary-search-tree/
 */
public class SearchRangeInBinarySearchTree {
    /**
     * Binary Search Tree
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        search(root, k1, k2, result);
        return result;
    }

    private void search(TreeNode node, int k1, int k2, List<Integer> result){
        if(k1 <= node.val && node.left != null){
            search(node.left, k1, k2, result);
        }
        if(node.val >= k1 && node.val <= k2){
            result.add(node.val);
        }
        if(k2 >= node.val && node.right != null){
            search(node.right, k1, k2, result);
        }
    }
}
