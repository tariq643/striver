package dsa.striver.linkedlist.faqHard;

public class SortALinkedList {

    private ListNode mergeTwoSortedLinkedList (ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        else {
            temp.next = list2;
        }
        return dummy.next;
    }

    private ListNode findMiddleOfLinkedList (ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeSort (ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middleOfLinkedList = findMiddleOfLinkedList(head);
        ListNode left = head, right = middleOfLinkedList.next;
        middleOfLinkedList.next = null;

        left = mergeSort(left);
        right = mergeSort(right);
        return mergeTwoSortedLinkedList(left, right);

    }

    public ListNode sortList(ListNode head) {


        return mergeSort(head);
    }
}


