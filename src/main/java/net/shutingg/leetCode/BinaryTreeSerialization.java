package net.shutingg.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/binary-tree-serialization/
 */
public class BinaryTreeSerialization {
    /**
     * BFS
     *
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#");
            } else {
                sb.append(node.val);
            }
            sb.append(",");
            if (node == null) {
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!strs[i].equals("#")) {
                node.left = new TreeNode(Integer.valueOf(strs[i]));
                queue.offer(node.left);
            }
            i++;
            if (!strs[i].equals("#")) {
                node.right = new TreeNode(Integer.valueOf(strs[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
