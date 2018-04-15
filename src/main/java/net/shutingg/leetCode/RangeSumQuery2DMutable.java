package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-mutable/description/
 *
 * Segment Tree
 */
public class RangeSumQuery2DMutable {
    private SegmentTreeNode[] roots;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        roots = new SegmentTreeNode[matrix.length];
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            roots[i] = buildHelper(matrix[i], 0, matrix[i].length - 1);
        }
    }

    public void update(int row, int col, int val) {
        modify(roots[row], col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += query(roots[i], col1, col2);
        }
        return sum;
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

    SegmentTreeNode buildHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }

        int mid = (end - start) / 2 + start;
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        node.left = buildHelper(nums, start, mid);
        node.right = buildHelper(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;

        return node;
    }

    void modify(SegmentTreeNode root, int index, int value) {
        if (root == null) {
            return;
        }
        if (index > root.end || index < root.start) {
            return;
        }
        if (root.start == root.end) {
            root.sum = value;
            return;
        }

        int mid = (root.end - root.start) / 2 + root.start;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    int query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        if (start > root.end || end < root.start) {
            return 0;
        }
        int mid = (root.end - root.start) / 2 + root.start;
        if (start < root.start) {
            start = root.start;
        }
        if (end > root.end) {
            end = root.end;
        }
        if (mid >= end) {
            return query(root.left, start, end);
        }
        if (mid < start) {
            return query(root.right, start, end);
        }
        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }
}
