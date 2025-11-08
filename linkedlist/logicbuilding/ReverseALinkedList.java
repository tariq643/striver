package dsa.striver.linkedlist.logicbuilding;

public class ReverseALinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode current = head, prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
