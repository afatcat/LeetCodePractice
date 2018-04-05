package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/convert-binary-tree-to-linked-lists-by-depth/
 */
public class ConvertBinaryTreeToLinkedListsByDepth {
    /**
     * Tree BFS with level
     *
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode last = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                ListNode ln = new ListNode(node.val);
                last.next = ln;
                last = ln;
            }
            res.add(dummy.next);
        }

        return res;
    }
}
