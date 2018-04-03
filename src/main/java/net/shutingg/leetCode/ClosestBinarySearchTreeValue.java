package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTreeValue {
    /**
     * upper bound and lower bound
     * O(h)
     *
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue3(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        TreeNode lower = lowerBound(root, target);
        TreeNode upper = upperBound(root, target);
        if (lower == null) {
            return upper.val;
        }
        if (upper == null) {
            return lower.val;
        }

        return Math.abs(lower.val - target) < Math.abs(upper.val - target) ? lower.val : upper.val;
    }

    private TreeNode lowerBound(TreeNode node, double target) {
        if (node == null) {
            return null;
        }

        if (node.val > target) {
            return lowerBound(node.left, target);
        }

        TreeNode right = lowerBound(node.right, target);
        if (right != null) {
            return right;
        }

        return node;
    }

    private TreeNode upperBound(TreeNode node, double target) {
        if (node == null) {
            return null;
        }

        if (node.val <= target) {
            return upperBound(node.right, target);
        }

        TreeNode left = upperBound(node.left, target);
        if (left != null) {
            return left;
        }

        return node;
    }



    private int value = 0;
    private double diff = Double.MAX_VALUE;

    /**
     * Post Order Traverse
     * O(n)
     *
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        postOrder(root, target);
        return value;
    }

    private void postOrder(TreeNode node, double target) {
        if (node.left != null) {
            postOrder(node.left, target);
        }
        if (node.right != null) {
            postOrder(node.right, target);
        }

        double curDiff = Math.abs((double) node.val - target);
        if (curDiff < diff) {
            value = node.val;
            diff = curDiff;
        }
    }



    /**
     * Divide and Conquer
     * O(n)
     *
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue2(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        Result result = dfs(root, target);
        return result.value;
    }

    private Result dfs(TreeNode node, double target) {
        if (node == null) {
            return new Result(0, Double.MAX_VALUE);
        }
        Result left = dfs(node.left, target);
        Result right = dfs(node.right, target);

        double curDiff = Math.abs((double) node.val - target);
        if (curDiff < left.diff && curDiff < right.diff) {
            return new Result(node.val, curDiff);
        } else if (left.diff < right.diff) {
            return left;
        } else {
            return right;
        }
    }

    class Result {
        int value;
        double diff;

        Result(int value, double diff) {
            this.value = value;
            this.diff = diff;
        }
    }
}
