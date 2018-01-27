package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    /**
     * LinkedList
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        for(int i =1; i < m; i++){
            pre = cur;
            cur = cur.next;
        }
        ListNode storedPre = pre;
        ListNode storedCur = cur;
        for(int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (storedPre != null) {
            storedPre.next = pre;
        }
        storedCur.next = cur;
        if (m == 1){
            return pre;
        } else {
            return head;
        }
    }
}
