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
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left!=null){
                stack.push(node.left);
                node.left = null;
            }else{
                result.add(node.val);
                stack.pop();
                if(node.right!=null){
                    stack.push(node.right);
                }
            }
        }
        return result;
    }
}
