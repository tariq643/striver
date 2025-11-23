package dsa.striver.linkedlist.faqMedium;

public class FindStartingPointLinkedList {

    public ListNode findStartingPoint(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // cycle is detected
            if (slow == fast) {

                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
