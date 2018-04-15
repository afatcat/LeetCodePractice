package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumQueryImmutable {
    private SegmentTreeNode root;

    /**
     * Segment Tree
     *
     * @param nums
     */
    public RangeSumQueryImmutable(int[] nums) {
        root = buildHelper(nums, 0, nums.length - 1);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
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

    int query(SegmentTreeNode node, int start, int end) {
        if (node == null) {
            return 0;
        }
        if (node.start == start && node.end == end) {
            return node.sum;
        }
        if (start > node.end || end < node.start) {
            return 0;
        }
        if (start < node.start) {
            start = node.start;
        }
        if (end > node.end) {
            end = node.end;
        }
        int mid = (node.end - node.start) / 2 + node.start;
        if (mid >= end) {
            return query(node.left, start, end);
        }
        if (mid < start) {
            return query(node.right, start, end);
        }
        return query(node.left, start, mid) + query(node.right, mid + 1, end);
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
}
