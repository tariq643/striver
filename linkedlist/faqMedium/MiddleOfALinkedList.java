package dsa.striver.linkedlist.faqMedium;

public class MiddleOfALinkedList {

    public ListNode middleOfLinkedList(ListNode head) {

        ListNode mid = head, fast = head;

        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        return mid;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}