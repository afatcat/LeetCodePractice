package net.shutingg.leetCode;

public class RemoveDuplicatesFromSortedListII {
    /*
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode mid = head;
        ListNode cur = head.next;

        while(cur != null){
            if(cur.val == mid.val){
                prev.next = cur.next;
                mid = cur;
                cur = cur.next;
            }else{
                if(prev.next != cur){
                    prev = mid;
                }
                mid = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
