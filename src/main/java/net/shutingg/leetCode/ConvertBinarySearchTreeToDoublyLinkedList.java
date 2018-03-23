package net.shutingg.leetCode;

class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
 }

/**
 * http://www.lintcode.com/en/problem/convert-binary-search-tree-to-doubly-linked-list/
 */
public class ConvertBinarySearchTreeToDoublyLinkedList {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Pair pair = inorder(root);
        return pair.first;
    }

    private Pair inorder(TreeNode node) {
        Pair left = null;
        if (node.left != null) {
            left = inorder(node.left);
        }
        Pair right = null;
        if (node.right != null) {
            right = inorder(node.right);
        }

        DoublyListNode dNode = new DoublyListNode(node.val);
        if (left != null) {
            left.last.next = dNode;
            dNode.prev = left.last;
        }
        if (right != null) {
            right.first.prev = dNode;
            dNode.next = right.first;
        }

        DoublyListNode first = left == null ? dNode : left.first;
        DoublyListNode last = right == null ? dNode : right.last;
        Pair pair = new Pair(first, last);
        return pair;
    }

    class Pair {
        DoublyListNode first;
        DoublyListNode last;
        Pair (DoublyListNode first, DoublyListNode last) {
            this.first = first;
            this.last = last;
        }
    }
}
