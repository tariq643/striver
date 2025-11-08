package dsa.striver.linkedlist.faqDll;

public class DeleteAllOccurencesOfAKeyInDLL {

    private void deleteNode (ListNode node) {

        ListNode next = node.next;
        ListNode prev = node.prev;

        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }

    public ListNode deleteAllOccurrences(ListNode head, int target) {

        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == target) {
                deleteNode(current);
            }
            current = current.next;
        }
        return dummyNode.next;
    }
}
