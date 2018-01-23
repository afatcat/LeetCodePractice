package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    /**
     * Tree Traverse
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res){
        if(node != null){
            res.add(node.val);
            preorder(node.left, res);
            preorder(node.right, res);
        }
    }
}
