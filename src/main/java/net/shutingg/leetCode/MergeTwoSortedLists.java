package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * http://www.lintcode.com/en/problem/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    /**
     * LinkedList
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        while (p1 != null && p2 != null){
            if (p1.val < p2.val) {
                prev.next = p1;
                prev = p1;
                p1 = p1.next;
            } else {
                prev.next = p2;
                prev = p2;
                p2 = p2.next;
            }
        }
        if (p1 == null) {
            prev.next = p2;
        } else {
            prev.next = p1;
        }

        return head.next;
    }
}
