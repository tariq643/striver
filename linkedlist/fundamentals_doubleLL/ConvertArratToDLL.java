package dsa.striver.linkedlist.fundamentals_doubleLL;

public class ConvertArratToDLL {

    public ListNode arrayToLinkedList(int [] nums) {

        ListNode head = new ListNode(nums[0]);
        ListNode prev = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}