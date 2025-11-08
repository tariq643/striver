package dsa.striver.linkedlist.faqHard;

public class ReverseLinkedListInGroupOfK {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode current = head;
        int count = k;

        while (current != null && count-- > 0) {
            current = current.next;
        }

        if (count > 0) {
            return head;
        }

        ListNode prev = reverseKGroup(current, k);
        ListNode currentHead = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = currentHead.next;
            currentHead.next = prev;
            prev = currentHead;
            currentHead = temp;
        }
        return prev;
    }
}
