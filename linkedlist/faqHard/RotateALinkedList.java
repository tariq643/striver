package dsa.striver.linkedlist.faqHard;

public class RotateALinkedList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int lengthOfLinkedList = 1;
        ListNode current = head;

        while (current.next != null) {
            current = current.next;
            lengthOfLinkedList = lengthOfLinkedList + 1;
        }


        current.next = head;
        k = k % lengthOfLinkedList;
        int result = lengthOfLinkedList - k;
        while (result-- > 0) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }
}
