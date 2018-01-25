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
        ListNode node1 = head;
        ListNode node2 = node1.next;
        while(node2 != null){
            while(node2 != null && node2.val == node1.val){
                node2 = node2.next;
            }
            node1.next = node2;
            node1 = node1.next;
            if(node2!=null){
                node2 = node2.next;
            }
        }
        return head;
    }
}
