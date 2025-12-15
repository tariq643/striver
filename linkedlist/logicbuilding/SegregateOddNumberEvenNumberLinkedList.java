package dsa.striver.linkedlist.logicbuilding;

public class SegregateOddNumberEvenNumberLinkedList {

    public ListNode oddEvenList(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode evenNumbers = new ListNode();
        ListNode oddNumbers = new ListNode();
        dummy.next = head;
        ListNode current = head;
//        while (current != null) {
//
//            if (current.data % 2 == 0) {
//                evenNumbers.data = current.data;
//            }
//            else {
//                oddNumbers.data = current.data;
//            }
//            current = current.next;
//        }
        evenNumbers.next = oddNumbers;
        dummy.next = evenNumbers;
        return dummy.next;
    }
}
