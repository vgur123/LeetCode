package org.easy.MergeSortedLinkedList;

public class RemoveDuplicates {

    public static ListNode addTwoNumbers(ListNode ln) {
        if (ln == null || ln.next == null) {
            return ln;
        }
        ListNode current = ln;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }

        return ln;
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
        ListNode head1 = new ListNode(2);;
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(5);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(7);

        ListNode res = addTwoNumbers(head1);
        printList(res);
    }
}
