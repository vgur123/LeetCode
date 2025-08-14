package org.easy.MergeSortedLinkedList;

public class TwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {


            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            int nextVal = sum % 10;
            curr.next = new ListNode(nextVal);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    static void printList(ListNode curr) {
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // First linked list: 5 -> 10 -> 15
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(3);

        // Second linked list: 2 -> 3 -> 20
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(head1, head2);
        printList(res);
    }
}
