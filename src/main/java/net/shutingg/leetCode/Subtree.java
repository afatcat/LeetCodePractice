package net.shutingg.leetCode;

public class Subtree {
    /*
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        if (T2 == null) {
            return true;
        }

        return traverse(T1, T2);
    }

    private boolean traverse(TreeNode T1, TreeNode T2) {
        if (T1.val == T2.val) {
            if (isIdentical(T1, T2)){
                return true;
            }
        }
        if (T1.left != null) {
            if (traverse(T1.left, T2)) {
                return true;
            }
        }
        if (T1.right != null) {
            if (traverse(T1.right, T2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIdentical(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        } else if (T1 == null || T2 == null) {
            return false;
        }
        if (T1.val != T2.val) {
            return false;
        }
        if (!isIdentical(T1.left, T2.left)) {
            return false;
        }
        if (!isIdentical(T1.right, T2.right)) {
            return false;
        }
        return true;
    }
}
