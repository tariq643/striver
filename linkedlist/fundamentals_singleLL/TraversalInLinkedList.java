package dsa.striver.linkedlist.fundamentals_singleLL;

import java.util.ArrayList;
import java.util.List;

public class TraversalInLinkedList {

    public List<Integer> LLTraversal(ListNode head) {

        ListNode current = head;
        List<Integer> traversal = new ArrayList<>();

        while (current != null) {
            traversal.add(current.val);
            current = current.next;
        }
        return traversal;
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
