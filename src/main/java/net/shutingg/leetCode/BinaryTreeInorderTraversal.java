package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root ==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}
