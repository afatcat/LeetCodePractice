package net.shutingg.leetCode;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/closest-binary-search-tree-value-ii/
 */
public class ClosestBinarySearchTreeValueII {
    PriorityQueue<Result> pq;
    /**
     * O(n) time and space, can be improved
     *
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> answer = new ArrayList<>();
        if (root == null || k == 0) {
            return answer;
        }
        pq = new PriorityQueue<>(k, (a, b) -> {
            if (a.diff < b.diff) {
                return -1;
            } else if (a.diff > b.diff) {
                return 1;
            } else {
                return 0;
            }
        });
        inorder(root, target);
        for (int i = 0; i < k; i++) {
            answer.add(pq.poll().value);
        }

        return answer;
    }

    private void inorder(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        inorder(root.left, target);
        double curDiff = Math.abs(root.val - target);
        pq.offer(new Result(curDiff, root.val));
        inorder(root.right, target);
    }

    class Result {
        double diff;
        int value;

        Result(double diff, int value) {
            this.diff = diff;
            this.value = value;
        }
    }
}
