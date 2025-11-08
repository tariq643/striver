package dsa.striver.linkedlist.fundamentals_singleLL;

public class DeletionAtHeadOfLinkedList {

    public ListNode deleteHead(ListNode head) {

        if (head == null) {
            return null;
        }
        return head.next;
    }
}
