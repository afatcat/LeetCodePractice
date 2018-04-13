package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/segment-tree-query/
 */
public class SegmentTreeQuery {
    /**
     * Segment Tree
     *
     * @param root:  The root of segment tree.
     * @param start: start value.
     * @param end:   end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root.start == root.end) {
            return root.max;
        }

        int mid = (root.start + root.end) / 2;
        if (start > mid) {
            return query(root.right, start, end);
        }
        if (end <= mid) {
            return query(root.left, start, end);
        }

        return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
    }

    class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }
}
