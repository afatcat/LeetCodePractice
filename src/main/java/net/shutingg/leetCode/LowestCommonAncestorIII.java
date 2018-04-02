package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/lowest-common-ancestor-iii/
 */
public class LowestCommonAncestorIII {
    /**
     * Tree DFS - divide and conquer
     *
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        Result result = divideConquer(root, A, B);
        return result.lca;
    }

    private Result divideConquer(TreeNode node, TreeNode A, TreeNode B) {
        if (node == null) {
            return new Result(false, false, null);
        }
        Result left = divideConquer(node.left, A, B);
        Result right = divideConquer(node.right, A, B);
        if (left.lca != null) {
            return left;
        }
        if (right.lca != null) {
            return right;
        }
        boolean aFound = left.aFound || right.aFound || node == A;
        boolean bFound = left.bFound || right.bFound || node == B;
        if (aFound && bFound) {
            return new Result(true, true, node);
        } else {
            return new Result(aFound, bFound, null);
        }
    }

    class Result {
        boolean aFound;
        boolean bFound;
        TreeNode lca;
        Result(boolean aFound, boolean bFound, TreeNode lca) {
            this.aFound = aFound;
            this.bFound = bFound;
            this.lca = lca;
        }
    }
}
