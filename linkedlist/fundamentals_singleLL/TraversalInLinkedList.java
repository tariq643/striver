package dsa.striver.linkedlist.fundamentals_singleLL;

import java.util.ArrayList;
import java.util.List;

public class TraversalInLinkedList {

    public List<Integer> LLTraversal(ListNode head) {

        ListNode current = head;
        List<Integer> traversal = new ArrayList<>();

        while (current != null) {
            traversal.add(current.data);
            current = current.next;
        }
        return traversal;
    }
}

class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
