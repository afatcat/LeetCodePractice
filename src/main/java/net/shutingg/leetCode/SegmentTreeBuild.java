package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/segment-tree-build/
 */
public class SegmentTreeBuild {
    /**
     * Segment Tree
     *
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end);
        }

        int mid = (end - start) / 2 + start;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        node.left = build(start, mid);
        node.right = build(mid + 1, end);

        return node;
    }

    class SegmentTreeNode {
        public int start, end;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }
}
