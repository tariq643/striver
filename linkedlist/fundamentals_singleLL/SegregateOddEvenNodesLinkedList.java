package dsa.striver.linkedlist.fundamentals_singleLL;

public class SegregateOddEvenNodesLinkedList {

    public ListNode oddEvenList(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy, current = head, even = null, odd = null;

        int index = 0;

        while (current != null) {

            if (index % 2 == 0) {
                even = current;
            }
            else {
                odd = current;
            }

            index++;
            current = current.next;
        }

        even.next = odd;

        return dummy.next;
    }
}
