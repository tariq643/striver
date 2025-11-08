package dsa.striver.linkedlist.faqMedium;

public class FindLengthOfLinkedList {

    private int findLengthLoop(ListNode slow, ListNode fast) {

        int length = 1;
        fast = fast.next;
        while (slow != fast) {

            length++;
            fast = fast.next;
        }
        return length;
    }

    public int findLengthOfLoop(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return findLengthLoop(slow, fast);
            }
        }
        return 0;
    }
}
