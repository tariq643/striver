package dsa.striver.linkedlist.faqMedium;

public class DetectACycleInLinkedList {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode mid = head, fast = head.next;

        while (fast != null && fast.next != null) {
            if (mid == fast) {
                return true;
            }
            mid = mid.next;
            fast = fast.next.next;
        }
        return false;
    }
}
