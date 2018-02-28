package net.shutingg.leetCode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubtree {
    /*
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Map<TreeNode, Integer> map = new HashMap<>();
        calSum(root, map);
        int max = Integer.MIN_VALUE;
        TreeNode maxNode = null;
        for (TreeNode key:map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                maxNode = key;
            }
        }

        return maxNode;
    }

    private int calSum(TreeNode node, Map<TreeNode, Integer> map) {
        if (map.get(node) != null) {
            return map.get(node);
        }
        int l = 0;
        if (node.left != null) {
            l = calSum(node.left, map);
        }
        int r = 0;
        if (node.right != null) {
            r = calSum(node.right, map);
        }
        int sum = node.val + l + r;
        map.put(node, sum);
        return sum;
    }
}
