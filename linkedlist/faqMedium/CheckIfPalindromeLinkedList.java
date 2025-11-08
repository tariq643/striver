package dsa.striver.linkedlist.faqMedium;

public class CheckIfPalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode mid = head, current = head, prev = null;

        while (current != null && current.next != null) {
            mid = mid.next;
            current = current.next.next;
        }

        mid = this.reverse(mid);

        current = head;
        while (mid != null) {
            if (current.val != mid.val) {
                return false;
            }
            current = current.next;
            mid = mid.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {

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
