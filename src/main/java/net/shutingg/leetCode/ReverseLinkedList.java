package net.shutingg.leetCode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode after = current.next;
        ListNode previous = null;
        while(after != null){
            ListNode tmp = after.next;
            after.next = current;
            current.next = previous;
            previous = current;
            current = after;
            after = tmp;
        }
        return current;
    }
}
