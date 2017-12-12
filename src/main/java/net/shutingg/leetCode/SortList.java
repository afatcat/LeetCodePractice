package net.shutingg.leetCode;

/**
 * Merge sort a LinkedList (in place)
 * https://leetcode.com/problems/sort-list/description/
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        //edge cases
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        //split into two lists
        ListNode pre = head; //node before p1
        ListNode p1 = head; //will be middle of list
        ListNode p2 = head; //move twice fast as p1
        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        pre.next = null;

        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);

        return merge(h1, h2);
    }

    //merge and sort, return head as the smallest node
    private ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }

        if(h1.val <= h2.val){
            h1.next = merge(h1.next, h2);
            return h1;
        }else{
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }
}
