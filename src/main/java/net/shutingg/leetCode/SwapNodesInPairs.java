package net.shutingg.leetCode;

/**
 * Created by sguan on 11/14/17.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode swap1 = head;
        ListNode swap2 = head.next;
        head = swapNext(swap1, swap2);
        if(swap1.next == null){
            return head;
        }
        //swap back
        ListNode tmp = swap2;
        swap2 = swap1;
        swap1 = tmp;

        ListNode prev = null;
        while(swap2.next!=null && swap2.next.next!=null){
            prev = swap1.next;
            swap1 = swap2.next;
            swap2 = swap2.next.next;
            prev.next = swapNext(swap1, swap2);
            tmp = swap2;
            swap2 = swap1;
            swap1 = tmp;
        }
        return head;
    }

    private ListNode swapNext(ListNode swap1, ListNode swap2){
        ListNode tmp = swap2.next;
        swap2.next = swap1;
        swap1.next = tmp;
        return swap2;
    }
}