package net.shutingg.leetCode;

public class DeleteNoteInALinkedList {
    static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "next=" + next +
                    ", val=" + val +
                    '}';
        }
    }

    public static void deleteNode(ListNode node) {//Java is by reference and thus changing reference itself will not work
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public static void main(String[] args){
        ListNode nodeA=new ListNode(1);
        ListNode nodeB=new ListNode(2);
        ListNode nodeC=new ListNode(3);
        nodeA.next=nodeB;
        nodeB.next=nodeC;
        System.out.println(nodeA);
        deleteNode(nodeB);
        System.out.println(nodeA);
    }
}
