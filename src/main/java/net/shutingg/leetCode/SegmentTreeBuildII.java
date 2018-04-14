package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/segment-tree-build-ii/
 */
public class SegmentTreeBuildII {
    /**
     * Segment Tree
     *
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        return buildHelper(A, 0, A.length - 1);
    }

    private SegmentTreeNode buildHelper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = (end - start) / 2 + start;
        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
        node.left = buildHelper(A, start, mid);
        node.right = buildHelper(A, mid + 1, end);
        node.max = Math.max(node.left.max, node.right.max);

        return node;
    }

    class SegmentTreeNode {
        int start;
        int end;
        int max;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
        }
    }
}
