package dsa.striver.linkedlist.logicbuilding;

import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromBackOfLL {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int lengthOfLinkedList = 0;
        ListNode current = head;

        while (current != null) {
            lengthOfLinkedList++;
            current = current.next;
        }

        if (lengthOfLinkedList == n) {
            return head.next;
        }

        current = head;
        int result = lengthOfLinkedList - n;
        while (current != null) {
            result--;
            if (result == 0) {
                break;
            }
            current = current.next;
        }
        ListNode nodeToBeDeleted = current.next;
        current.next = current.next.next;
        nodeToBeDeleted = null;
        return head;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;
        ListNode head = new ListNode(arr.get(0));
        head.next = new ListNode(arr.get(1));
        head.next.next = new ListNode(arr.get(2));
        head.next.next.next = new ListNode(arr.get(3));
        head.next.next.next.next = new ListNode(arr.get(4));

        // Solution instance
        RemoveNthNodeFromBackOfLL sol = new RemoveNthNodeFromBackOfLL();
        head = sol.removeNthFromEnd(head, N);
    }
}
