package dsa.striver.linkedlist.fundamentals_singleLL;

public class InsertionAtTheKthPositionOfLinkedList {

    public ListNode insertAtKthPosition(ListNode head, int x, int k) {
        //YOUR CODE GOES HERE
        if (head == null) {
            if (k == 1) {
                return new ListNode(x);
            }
            else {
                return head;
            }
        }
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                ListNode newNode = new ListNode(x, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
