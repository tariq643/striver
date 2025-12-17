package dsa.striver.linkedlist.faqMedium;

public class AddOneToANumberRepresentedByLL {

    public ListNode addOne(ListNode head) {

        if (head == null) {
            return head;
        }
        int carry = 1;
        head = this.reverseList(head);
        ListNode temp = head;
        while (temp != null && carry != 0) {
            int sum = temp.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            temp.val = sum;
            if (temp.next == null && carry != 0) {
                temp.next = new ListNode(carry);
                break;
            }
            temp = temp.next;
        }
        return this.reverseList(head);
    }

    private ListNode reverseList(ListNode node) {

        ListNode temp = node, prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Creation of Linked List
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        // Solution instance
        AddOneToANumberRepresentedByLL solution = new AddOneToANumberRepresentedByLL();
        head1 = solution.addOne(head1);
        System.out.print("Result after adding one: ");
        printList(head1);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
