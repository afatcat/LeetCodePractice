package net.shutingg.leetCode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(lists.size(),
                (n1, n2) -> n1.val - n2.val);
        for(ListNode node : lists) {
            while(node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode head = queue.poll();
        ListNode pre = head;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            pre.next = node;
            pre = node;
        }
        if(pre != null){
            pre.next = null;
        }

        return head;
    }
}
