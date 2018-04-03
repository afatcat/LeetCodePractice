package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/subtree-with-maximum-average/
 */
public class SubtreeWithMaximumAverage {
    /**
     * Divide and Conquer
     *
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        Result result = dfs(root);
        return result.maxNode;
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(0, 0, -Double.MAX_VALUE, null);
        }

        Result left = dfs(node.left);
        Result right = dfs(node.right);
        double sum = node.val + left.sum + right.sum;
        double count = 1 + left.count + right.count;
        double avg = sum / count;

        Result current = new Result(sum, count, avg, node);
        if (left.avg > avg && left.avg > right.avg) {
            current.avg = left.avg;
            current.maxNode = left.maxNode;
        } else if (right.avg > avg && right.avg > left.avg) {
            current.avg = right.avg;
            current.maxNode = right.maxNode;
        }

        return current;
    }

    class Result {
        double sum;
        double count;
        double avg;
        TreeNode maxNode;

        Result(double sum, double count, double avg, TreeNode node) {
            this.sum = sum;
            this.count = count;
            this.avg = avg;
            maxNode = node;
        }
    }
}
