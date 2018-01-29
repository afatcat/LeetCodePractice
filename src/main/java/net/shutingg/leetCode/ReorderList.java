package net.shutingg.leetCode;

public class ReorderList {
    /**
     * LinkedList
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode middle = findMiddle(head);
        if(middle.next == null) {
            return;
        }
        ListNode half = reverse(middle);
        if(head.next == middle) {
            head.next = half;
            return;
        }
        middle.next = null;
        while(head != null && half != null) {
            if(head.next == middle) {
                head.next = null;
            }
            ListNode tmp1 = head.next;
            head.next = half;
            ListNode tmp2 = half.next;
            if(tmp1 == null) {
                half.next = tmp2;
                return;
            }
            half.next = tmp1;
            head = tmp1;
            half = tmp2;
        }
    }

    private ListNode findMiddle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head.next != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        head.next = pre;

        return head;
    }
}
