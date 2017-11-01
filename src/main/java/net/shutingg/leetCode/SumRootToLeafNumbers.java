package net.shutingg.leetCode;

import java.util.LinkedList;

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
        int result = 0;
        LinkedList<Integer> links = new LinkedList<>();
        linkNumber(root, 0, links);
        for(int l:links){
            result+=l;
        }
        return result;
    }

    void linkNumber(TreeNode node, int parentVal, LinkedList<Integer> links){
        if(node.left == null && node.right == null){
            links.add(parentVal*10+node.val);
        }
        if(node.left != null){
            linkNumber(node.left, parentVal*10+node.val, links);
        }
        if(node.right != null){
            linkNumber(node.right, parentVal*10+node.val, links);
        }
    }
}
