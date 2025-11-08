package dsa.striver.linkedlist.logicbuilding;

public class Sort0s1s2s {

    public ListNode sortList(ListNode head) {

        int count0 = 0, count1 = 0, count2 = 0;
        ListNode current = head;

        while (current != null) {
            if (current.val == 0) {
                count0++;
            }
            else if (current.val == 1) {
                count1++;
            }
            else {
                count2++;
            }
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (count0-- > 0) {
                current.val = 0;
            }
            else if (count1-- > 0) {
                current.val = 1;
            }
            else {
                current.val = 2;
            }
            current = current.next;
        }
        return head;
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