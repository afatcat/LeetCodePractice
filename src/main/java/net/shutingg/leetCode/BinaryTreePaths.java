package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 * http://lintcode.com/en/problem/binary-tree-paths/
 */
public class BinaryTreePaths {
    /**
     * Tree Traverse
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root, new ArrayList<>(), result);

        return result;
    }

    private void helper(TreeNode node, List<Integer> current, List<String> res){
        current.add(node.val);
        if(node.left != null){
            List<Integer> nList = new ArrayList<>(current);
            helper(node.left, nList, res);
        }
        if(node.right != null){
            List<Integer> nList = new ArrayList<>(current);
            helper(node.right, nList, res);
        }
        if(node.left == null && node.right == null){
            res.add(listToString(current));
        }
    }

    private String listToString(List<Integer> list){
        String str = ""+list.get(0);
        for(int i = 1; i < list.size(); i++){
            str += "->"+list.get(i);
        }
        return str;
    }
}
