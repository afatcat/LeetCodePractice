package net.shutingg.leetCode;

import java.util.*;
public class BinaryTreeVerticalOrderTraversal {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nQueue = new LinkedList<>();
        Queue<Integer> pQueue = new LinkedList<>();
        nQueue.offer(root);
        pQueue.offer(0);

        Map<Integer, List<Integer>> map = new HashMap<>();

        while (!nQueue.isEmpty()) {
            TreeNode node = nQueue.poll();
            int pl = pQueue.poll();
            map.putIfAbsent(pl, new ArrayList<>());
            map.get(pl).add(node.val);
            if (node.left != null) {
                nQueue.offer(node.left);
                pQueue.offer(pl - 1);
            }
            if (node.right != null) {
                nQueue.offer(node.right);
                pQueue.offer(pl + 1);
            }
        }

        List<Integer> places = new ArrayList<>(map.keySet());
        Collections.sort(places);
        for (int p : places) {
            res.add(map.get(p));
        }

        return res;
    }
}
