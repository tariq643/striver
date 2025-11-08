package dsa.striver.linkedlist.logicbuilding;

public class SegregateOddNumberEvenNumberLinkedList {

    public ListNode oddEvenList(ListNode head) {

        ListNode evenNumbers = new ListNode();
        ListNode oddNumbers = new ListNode();
        ListNode current = head;
        while (current != null) {

            if (current.val % 2 == 0) {
                evenNumbers.val = current.val;
            }
            else {
                oddNumbers.val = current.val;
            }
            current = current.next;
        }
        return head;
    }
}
