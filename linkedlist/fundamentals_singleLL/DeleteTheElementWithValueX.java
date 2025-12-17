package dsa.striver.linkedlist.fundamentals_singleLL;

public class DeleteTheElementWithValueX {

    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        //YOUR CODE GOES HERE
        if (head == null)
            return head;

        // If first node has target value, delete
        if (head.data == X) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        /* Traverse the list to find
        the node with the target value */
        while (temp != null) {
            if (temp.data == X) {
                // Adjust the pointers
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}
