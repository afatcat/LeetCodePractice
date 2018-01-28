package net.shutingg.leetCode;

/**
 * https://leetcode.com/problems/partition-list/description/
 * http://www.lintcode.com/en/problem/partition-list/
 */
public class PartitionList {
    /**
     * LinkedList
     * (To improve: you don't need that many parameters)
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        ListNode firstP1 = null;
        ListNode firstP2 = null;
        while (head != null) {
            if(head.val < x) {
                if(firstP1 == null){
                    firstP1 = head;
                }
                p1.next = head;
                p1 = p1.next;
            } else {
                if (firstP2 == null) {
                    firstP2 = head;
                }
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = firstP2;
        p2.next = null;
        if(firstP1 == null) {
            return firstP2;
        }
        return firstP1;
    }
}
