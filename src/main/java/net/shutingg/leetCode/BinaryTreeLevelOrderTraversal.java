package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * http://lintcode.com/en/problem/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * Tree Traverse - BFS
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.add(root);
        while(queue.peek() != null){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}
