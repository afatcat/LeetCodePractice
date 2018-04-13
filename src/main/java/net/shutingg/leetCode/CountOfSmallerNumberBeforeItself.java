package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/count-of-smaller-number-before-itself/
 * Segment Tree
 */
public class CountOfSmallerNumberBeforeItself {
    //for i
    //    query(root, 0, A[i] - 1)
    //    modify(root, A[i], +1)

    private SegmentTreeNode root;

    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        List<Integer> results = new ArrayList<>();
        root = build(10000);
        for (int i = 0; i < A.length; i++) {
            int count = A[i] == 0 ? 0 : query(root, 0, A[i] - 1);
            results.add(count);
            addOne(root, A[i]);
        }

        return results;
    }

    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    SegmentTreeNode build(int num) {
        return buildHelper(0, num);
    }

    SegmentTreeNode buildHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end, 0);
        }

        int mid = (end - start) / 2 + start;
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        node.left = buildHelper(start, mid);
        node.right = buildHelper(mid + 1, end);

        return node;
    }

    int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }

        int mid = (root.end - root.start) / 2 + root.start;
        if (end <= mid) {
            return query(root.left, start, end);
        }
        if (start > mid) {
            return query(root.right, start, end);
        }

        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }

    void addOne(SegmentTreeNode root, int index) {
        if (root.start == root.end) {
            root.sum++;
            return;
        }

        int mid = (root.end - root.start) / 2 + root.start;
        if (index <= mid) {
            addOne(root.left, index);
        } else {
            addOne(root.right, index);
        }
        root.sum++;
    }
}
