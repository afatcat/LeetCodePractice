package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/interval-sum-ii/
 */
public class IntervalSumII {
    /* you may need to use some attributes here */
    private SegmentTreeNode root;

    /*
    * @param A: An integer array
    */
    public IntervalSumII(int[] A) {
        root = build(A);
    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return queryNode(root, start, end);
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        modifyNode(root, index, value);
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

        int mid = (start + end) / 2;
        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
        node.left = buildHelper(A, start, mid);
        node.right = buildHelper(A, mid + 1, end);
        node.sum = node.left.sum + node.right.sum; // no need to do null check as only leaves have no left or right child

        return node;
    }

    void modifyNode(SegmentTreeNode node, int index, int value) {
        if (node.start == node.end) {
            node.sum = value;
            return;
        }

        int mid = (node.start + node.end) / 2;
        if (index <= mid) {
            modifyNode(node.left, index, value);
        } else {
            modifyNode(node.right, index, value);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    long queryNode(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) { //important!!!
            return node.sum;
        }

        int mid = (node.start + node.end) / 2;
        if (start > mid) {
            return queryNode(node.right, start, end);
        }
        if (end <= mid) {
            return queryNode(node.left, start, end);
        }

        return queryNode(node.left, start, mid) + queryNode(node.right, mid + 1, end);
    }
}
