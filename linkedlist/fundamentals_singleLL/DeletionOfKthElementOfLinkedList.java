package dsa.striver.linkedlist.fundamentals_singleLL;

public class DeletionOfKthElementOfLinkedList {

    public ListNode deleteKthNode(ListNode head, int k) {

        if (head == null)
            return null;

        // If k is 1, delete the head node
        if (k == 1) {
            ListNode temp = head;
            head = head.next;
            return head;
        }

        // Initialize a temporary pointer
        ListNode temp = head;

        // Traverse to the (k-1)th node
        for (int i = 0; temp != null && i < k - 2; i++) {
            temp = temp.next;
        }

        /* If k is greater than the number of nodes,
        return the unchanged list */
        if (temp == null || temp.next == null)
            return head;

        // Delete the k-th node
        ListNode next = temp.next.next;
        temp.next = next;

        // Return head
        return head;
    }
}
