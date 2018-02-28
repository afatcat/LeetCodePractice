package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {
    /**
     * DFS
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int p = findLargets(nums, start, end);
        TreeNode node = new TreeNode(nums[p]);
        node.left = dfs(nums, start, p - 1);
        node.right = dfs(nums, p + 1, end);
        return node;
    }

    private int findLargets(int[] nums, int start, int end) {
        int p = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[p] < nums[i]) {
                p = i;
            }
        }
        return p;
    }
}
