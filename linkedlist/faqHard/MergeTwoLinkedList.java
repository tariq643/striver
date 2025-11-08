package dsa.striver.linkedlist.faqHard;

public class MergeTwoLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode temp = dummyNode;

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
        if (list2 != null) {
            temp.next = list2;
        }

        return dummyNode.next;

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