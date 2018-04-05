package net.shutingg.leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BinaryTreeRightSideView {
    /**
     * Tree BFS with level
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            res.add(node.val);
            for (int i = 1; i < size; i++) {
                node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return res;
    }
}
