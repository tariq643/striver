package dsa.striver.linkedlist.fundamentals_singleLL;

public class InsertionAtEndOfLinkedList {

    public ListNode insertAtTail(ListNode head, int X) {

        if (head == null) {
            return new ListNode(X);
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        ListNode newNode = new ListNode(X);
        current.next = newNode;
        return head;
    }
}
