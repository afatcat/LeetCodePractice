package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/segment-tree-query-ii/
 */
public class SegmentTreeQueryII {
    /**
     * Segment Tree
     *
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.count;
        }
        if (root.start == root.end) {
            return root.count;
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
        if (end <= mid) {
            return query(root.left, start, end);
        }
        if (start > mid) {
            return query(root.right, start, end);
        }
        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }

    class SegmentTreeNode {
        int start;
        int end;
        int count;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }
}
