package dsa.striver.linkedlist.fundamentals_doubleLL;

public class DeleteHeadOfLInkedList {

    public ListNode deleteHead(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode next = head.next;
        next.prev = null;
        return head.next;
    }
}
