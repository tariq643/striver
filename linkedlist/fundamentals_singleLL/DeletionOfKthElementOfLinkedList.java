package dsa.striver.linkedlist.fundamentals_singleLL;

public class DeletionOfKthElementOfLinkedList {

    public ListNode deleteKthNode(ListNode head, int k) {

        ListNode current = head;
        while (k-- > 0 && current != null) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}
