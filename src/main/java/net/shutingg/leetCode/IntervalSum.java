package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/interval-sum/
 */
public class IntervalSum {
    private SegmentTreeNode root;
    /**
     * Segment Tree
     *
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        List<Long> res = new ArrayList<>();
        if (A == null || queries == null || queries.size() == 0) {
            return res;
        }
        root = build(A);
        for (Interval query : queries) {
            long count = query(root, query.start, query.end);
            res.add(count);
        }

        return res;
    }

    class SegmentTreeNode {
        int start;
        int end;
        long sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    SegmentTreeNode build(int[] A) {
        return buildHelper(A, 0, A.length - 1);
    }

    SegmentTreeNode buildHelper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = (end - start) / 2 + start;
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        node.left = buildHelper(A, start, mid);
        node.right = buildHelper(A, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;

        return node;
    }

    long query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        if (root.start == root.end) {
            return root.sum;
        }
        if (start > root.end) {
            return 0;
        }
        if (end < root.start) {
            return 0;
        }
        if (end > root.end) {
            end = root.end;
        }
        if (start < root.start) {
            start = root.start;
        }
        int mid = (root.end - root.start) / 2 + root.start;
        if (mid >= end) {
            return query(root.left, start, end);
        }
        if (mid < start) {
            return query(root.right, start, end);
        }
        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }
}
