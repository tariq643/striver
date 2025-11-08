package dsa.striver.linkedlist.fundamentals_singleLL;

public class InsertionAtHeadOfLinkedList {

    public ListNode insertAtHead(ListNode head, int X) {

        ListNode dummyNode = new ListNode(X);
        dummyNode.next = head;
        return dummyNode;
    }
}
