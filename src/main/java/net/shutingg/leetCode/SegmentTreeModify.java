package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/segment-tree-modify/
 */
public class SegmentTreeModify {
    /**
     * Segment Tree
     *
     * @param root:  The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        if (index < root.start || index > root.end) {
            return;
        }

        if (root.start == root.end) {
            root.max = value;
            return;
        }

        int mid = (root.start + root.end) / 2;
        if (root.left != null && index <= mid) {
            modify(root.left, index, value);
        }
        if (root.right != null && index > mid) {
            modify(root.right, index, value);
        }

        root.max = Math.max(root.left.max, root.right.max);
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
