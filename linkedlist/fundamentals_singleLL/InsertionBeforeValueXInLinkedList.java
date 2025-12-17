package dsa.striver.linkedlist.fundamentals_singleLL;

public class InsertionBeforeValueXInLinkedList {

    public ListNode insertBeforeX(ListNode head, int x, int val) {
        //YOUR CODE GOES HERE
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (head.data == x) {
                ListNode newNode = new ListNode(val);
                newNode.next = head;
                return newNode;
            }
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        boolean xPresentFlag = false;
        while (current != null && current.next != null) {
            if (current.next.data == x) {
                xPresentFlag = true;
                break;
            }
            current = current.next;
        }
        if (xPresentFlag) {
            ListNode newNode = new ListNode(val,current.next);
            current.next = newNode;
            return dummy.next;
        }
        return dummy.next;
    }
}
