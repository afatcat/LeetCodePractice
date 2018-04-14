package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/interval-minimum-number/
 */
public class IntervalMinimumNumber {
    private SegmentTreeNode root;

    /**
     * Segment Tree
     *
     * @param A: An integer array
     * @param queries: An query list
     * @return: The result list
     */
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        List<Integer> res = new ArrayList<>();
        if (A == null || queries == null || queries.size() == 0) {
            return res;
        }
        root = build(A);
        for (Interval q : queries) {
            int min = query(root, q.start, q.end);
            res.add(min);
        }

        return res;
    }

    class SegmentTreeNode {
        int start;
        int end;
        int min;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
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
        int mid = (start + end) / 2;
        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
        node.left = buildHelper(A, start, mid);
        node.right = buildHelper(A, mid + 1, end);
        node.min = Math.min(node.left.min, node.right.min);
        return node;
    }

    int query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.min;
        }
        if (start > root.end) {
            return -1;
        }
        if (end < root.start) {
            return -1;
        }
        if (start < root.start) {
            start = root.start;
        }
        if (end > root.end) {
            end = root.end;
        }
        int mid = (root.end - root.start) / 2 + root.start;
        if (mid >= end) {
            return query(root.left, start, end);
        }
        if (mid < start) {
            return query(root.right, start, end);
        }
        return Math.min(query(root.left, start, mid), query(root.right, mid + 1, end));
    }
}
