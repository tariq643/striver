package dsa.striver.linkedlist.fundamentals_doubleLL;

public class InsertNodeBeforeHeadDLL {

    public ListNode insertBeforeHead(ListNode head, int X) {

        if (head == null) {
            return new ListNode(X);
        }
        ListNode newNode = new ListNode(X);
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }
}
