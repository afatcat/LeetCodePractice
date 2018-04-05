package net.shutingg.leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    /**
     * Sort only the head of the lists
     * Use Insertion Sort for almost sorted lists to reduce each sort time to O(k)
     *
     * Time O(k log k + k * n)?
     * Space O(k)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode last = dummy;

        sortLists(lists);
        lists = shinkList(lists);
        while (lists.length > 0 && lists[0] != null) {
            if (lists[0] != null) {
                last.next = lists[0];
                lists[0] = lists[0].next;
                last = last.next;
            }
            if (lists[0] == null) {
                lists = Arrays.copyOfRange(lists, 1, lists.length);
            } else {
                insertionSort(lists);
                lists = shinkList(lists);
            }
        }

        return dummy.next;
    }

    private void sortLists(ListNode[] lists) {
        Arrays.sort(lists, (a, b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return 1;
            } else if (b == null) {
                return -1;
            } else {
                return a.val - b.val;
            }
        });
    }

    private void insertionSort(ListNode[] lists) {
        int i = 1;
        while (i < lists.length) {
            int j = i - 1;
            ListNode xNode = lists[i];
            while (j >= 0 && lists[j].val > xNode.val) {
                lists[j + 1] = lists[j];
                j--;
            }
            lists[j + 1] = xNode;
            i++;
        }
    }

    private ListNode[] shinkList(ListNode[] lists) {
        int boundary = findFirstNull(lists);
        if (boundary < lists.length) {
            return Arrays.copyOf(lists, boundary);
        }
        return lists;
    }

    private int findFirstNull(ListNode[] lists) {
        int st = 0;
        int end = lists.length - 1;
        while (st + 1 < end) {
            int pl = (end - st) / 2 + st;
            if (lists[pl] == null) {
                end = pl;
            } else {
                st = pl;
            }
        }
        if (lists[st] == null) {
            return st;
        }
        if (lists[end] == null) {
            return end;
        }
        return lists.length;
    }



    /**
     * PriorityQueue
     * Time O(n log n)
     * Space O(n)
     *
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
