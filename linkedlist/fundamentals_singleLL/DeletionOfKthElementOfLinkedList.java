package dsa.striver.linkedlist.fundamentals_singleLL;

public class DeletionOfKthElementOfLinkedList {

    public ListNode deleteKthNode(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (k-- >= 1 && current != null) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}
