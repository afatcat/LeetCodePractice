package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/binary-tree-longest-consecutive-sequence-ii/
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    int longest = 0;
    /**
     * Tree DFS
     *
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        findLength(root);
        return longest;
    }

    private Result findLength(TreeNode node) {
        if(node == null) {
            return new Result(0, 0);
        }

        Result left = findLength(node.left);
        Result right = findLength(node.right);
        int length1 = 1;
        int length2 = 1;
        int totalLength = 1;
        if (node.left != null && node.left.val == node.val - 1) {
            length2 = left.length2 + 1;
            if (node.right != null && node.right.val == node.val + 1) {
                totalLength = left.length2 + 1 + right.length1;
            }
        } else if (node.left != null && node.left.val == node.val + 1) {
            length1 = left.length1 + 1;
            if (node.right != null && node.right.val == node.val - 1) {
                totalLength = left.length1 + 1 + right.length2;
            }
        }

        if (node.right != null && node.right.val == node.val - 1) {
            length2 = Math.max(length2, right.length2 + 1);
            if (node.left != null && node.left.val == node.val + 1) {
                totalLength = Math.max(totalLength, right.length2 + 1 + left.length1);
            }
        } else if (node.right != null && node.right.val == node.val + 1) {
            length1 = Math.max(length1, right.length1 + 1);
            if (node.left != null && node.left.val == node.val - 1) {
                totalLength = Math.max(totalLength, right.length1 + 1 + left.length2);
            }
        }

        longest = Math.max(longest, totalLength);
        longest = Math.max(longest, length1);
        longest = Math.max(longest, length2);
        return new Result(length1, length2);
    }

    class Result {
        int length1;
        int length2;
        Result (int length1, int length2) {
            this.length1 = length1;
            this.length2 = length2;
        }
    }
}
