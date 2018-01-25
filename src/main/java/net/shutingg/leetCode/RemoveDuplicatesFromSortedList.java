package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * LinkedList
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode prev = head;
        ListNode node = head.next;
        while(node != null) {
            if(prev.val != node.val){
                prev = node;
            }
            node = node.next;
            prev.next = node;
        }
        return head;
    }
}
