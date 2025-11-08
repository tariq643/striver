package dsa.striver.linkedlist.faqDll;

public class RemoveDuplicatesFromSortedDLL {

    public ListNode removeDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }

        current = head;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null && current.prev != null) {

            if (current.val == current.prev.val) {
                current.prev = current.prev.prev;
            }
            else {
                current = current.prev;
            }
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }
    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }
    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}