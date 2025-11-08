package dsa.striver.linkedlist.faqMedium;

public class DeleteTheNodeInMiddleOfLinkedList {

    public ListNode deleteMiddle(ListNode head) {

        /* Edge case: if the list is empty
         * or has only one node, return null */
        if (head == null || head.next == null) {
            return null;
        }

        int lengthOfLinkedList = 0;
        ListNode current = head;
        while (current != null) {
            lengthOfLinkedList++;
            current = current.next;
        }

        int middleIndex = lengthOfLinkedList / 2;

        current = head;

        for (int i = 1; i < middleIndex; i++) {
            current = current.next;
        }

        ListNode middle = current;
        current.next = current.next.next;
        middle = null;
        return head;
    }
}
