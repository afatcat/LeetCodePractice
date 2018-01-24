package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        List<TreeNode> result = new ArrayList<>();
        helper(root, A, B, result);
        return result.get(0);
    }

    private boolean helper(TreeNode node, TreeNode A, TreeNode B, List<TreeNode> result){
        boolean found1 = node == A;
        boolean found2 = node == B;
        if(found1 && found2){
            result.add(node);
            return false;
        }
        found1 = found1 || found2;
        found2 = false;

        if(node.left != null){
            found2 = helper(node.left, A, B, result);
        }
        if(found1 && found2){
            result.add(node);
            return false;
        }
        boolean found3 = false;
        if(node.right != null){
            found3 = helper(node.right, A, B, result);
        }
        if(found1 && found3 || found2 && found3){
            result.add(node);
            return false;
        }
        if(found1 || found2 || found3){
            return true;
        }
        return false;
    }
}
