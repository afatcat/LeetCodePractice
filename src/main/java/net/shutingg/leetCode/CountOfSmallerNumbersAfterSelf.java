package net.shutingg.leetCode;

import java.util.*;

/**
 * https://www.lintcode.com/en/problem/count-of-smaller-numbers-after-self/
 */
public class CountOfSmallerNumbersAfterSelf {
    /**
     * Segment Tree
     *
     * @param nums: a list of integers
     * @return: return a list of integers
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] ranks = getRanks(nums);
        SegmentTreeNode root = build(0, ranks.length - 1);
        for (int i = ranks.length - 1; i >= 0; i--) {
            int count = query(root, 0, ranks[i] - 1);
            result.add(0, count);
            addOne(root, ranks[i]);
        }

        return result;
    }

    private int[] getRanks(int[] nums) {
        int[] ranks = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            ranks[i] = Arrays.binarySearch(nums, ranks[i]);
        }

        return ranks;
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

    SegmentTreeNode build(int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, 0);
        }
        if (start > end) {
            return null;
        }

        int mid = (end - start) / 2 + start;
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        node.left = build(start, mid);
        node.right = build(mid + 1, end);
        return node;
    }

    void addOne(SegmentTreeNode root, int index) {
        if (index < root.start || index > root.end) {
            return;
        }

        if (root.start == root.end) {
            root.count++;
            return;
        }

        int mid = (root.end - root.start) / 2 + root.start;
        if (index <= mid) {
            addOne(root.left, index);
        } else {
            addOne(root.right, index);
        }

        root.count++;
    }

    int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.count;
        }
        if (start > root.end || end < root.start) {
            return 0;
        }
        if (start < root.start) {
            start = root.start;
        }
        if (end > root.end) {
            end = root.end;
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
}
