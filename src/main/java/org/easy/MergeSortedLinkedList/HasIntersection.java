package org.easy.MergeSortedLinkedList;

import java.util.ArrayList;
import java.util.Collections;

class HasIntersection {

    // Function to get the intersection point of two linked lists
    static ListNode intersectPoint(ListNode head1, ListNode head2) {

        // Maintaining two pointers ptr1 and ptr2
        // at the heads of the lists
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        // If any one of the heads is NULL, there is no intersection
        if (ptr1 == null || ptr2 == null)
            return null;

        // Traverse through the lists until both pointers meet
        while (ptr1 != ptr2) {

            // Move to the next node in each list and if the one
            // pointer reaches NULL, start from the other linked list
            ptr1 = (ptr1 != null) ? ptr1.next : head2;
            ptr2 = (ptr2 != null) ? ptr2.next : head1;
        }

        // Return the intersection node, or null if no intersection
        return ptr1;


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

        // First linked list
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(8);


        // Second linked list
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(8);
        head2.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next.next = null;

        head2.next.next.next = head1.next;

        ListNode res = intersectPoint(head1, head2);
        printList(res);
    }
}
