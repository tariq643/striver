package dsa.striver.linkedlist.fundamentals_singleLL;

public class DeletionOfKthElementOfLinkedList {

    public ListNode deleteKthNode(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode current = head;
        while (k-- >= 1 && current != null) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}
